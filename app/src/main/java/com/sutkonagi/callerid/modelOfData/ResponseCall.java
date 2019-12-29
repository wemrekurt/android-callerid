package com.sutkonagi.callerid.modelOfData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by emrek on 29.12.2019.
 */

public class ResponseCall {
  @SerializedName("success")
  @Expose
  private Boolean success;
  @SerializedName("phone")
  @Expose
  private String phone;
  @SerializedName("customer")
  @Expose
  private String customer;


  public String getPhone() {
    return phone;
  }
  public String getCustomer() {
    return customer;
  }
  public Boolean getSuccess() {
    return success;
  }

}
