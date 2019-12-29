package com.sutkonagi.callerid.api.interfaced;

import com.sutkonagi.callerid.modelOfData.ResponseCall;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by emrek on 29.12.2019.
 */

public interface CallService {
  @GET("call")
  Call< ResponseCall > saveCall(@Query("phone") String phone, @Query("call_type") String call_type);
}
