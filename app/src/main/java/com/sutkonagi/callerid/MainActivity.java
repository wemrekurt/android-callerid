package com.sutkonagi.callerid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sutkonagi.callerid.api.RetrofitClient;
import com.sutkonagi.callerid.api.interfaced.CallService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by emrek on 29.12.2019.
 */

public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

}
