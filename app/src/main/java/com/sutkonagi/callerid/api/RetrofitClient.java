package com.sutkonagi.callerid.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by emrek on 29.12.2019.
 */

public class RetrofitClient {
  private static Retrofit retrofit = null;
  public static final String BASE_URL = "http://192.168.1.33:3000/api/v1/";

  public static Retrofit getClient() {
    if(retrofit == null){
      retrofit = new Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }
    return retrofit;
  }
}
