package com.sutkonagi.callerid;

/**
 * Created by emrek on 29.12.2019.
 */


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.sutkonagi.callerid.api.RetrofitClient;
import com.sutkonagi.callerid.api.interfaced.CallService;
import com.sutkonagi.callerid.modelOfData.ResponseCall;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by theappguruz on 07/05/16.
 */
public class PhoneStateReceiver extends BroadcastReceiver {
  @Override
  public void onReceive(Context context, Intent intent) {
    try {

      String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
      String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

      if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
        sendRequest(incomingNumber, "incoming");
        Log.d("INFO", incomingNumber);
        //Toast.makeText(context,"Incoming Call State",Toast.LENGTH_SHORT).show();
        //Toast.makeText(context,"Ringing State Number is -"+incomingNumber,Toast.LENGTH_SHORT).show();
      }
      if ((state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))){
        sendRequest(incomingNumber, "received");
        //Toast.makeText(context,"Call Received State",Toast.LENGTH_SHORT).show();
      }
      if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)){
        sendRequest(incomingNumber, "idle");
        //Toast.makeText(context,"Call Idle State",Toast.LENGTH_SHORT).show();
      }
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }

  private void sendRequest(String phone, String call_type){
    if(phone.length() < 1)
        return;

    Retrofit retrofit = RetrofitClient.getClient();
    CallService cssr = retrofit.create(CallService.class);
    Call call = cssr.saveCall(phone, call_type);
    call.enqueue(new Callback() {
      @Override
      public void onResponse(Call call, Response response) {
       /* ResponseCall rc = (ResponseCall) response.body();
        Log.d("INFO", rc.getPhone());
        Log.d("INFO", rc.getCustomer());
        */
      }

      @Override
      public void onFailure(Call call, Throwable t) {

      }
    });
  }
}
