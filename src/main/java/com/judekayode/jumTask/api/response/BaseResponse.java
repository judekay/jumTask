package com.judekayode.jumTask.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class BaseResponse {

    @SerializedName("number") public Map number;
    @SerializedName("scheme") public String scheme;
    @SerializedName("type") public String type;
    @SerializedName("brand") public String brand;
    @SerializedName("prepaid") public String prepaid;
    @SerializedName("country") public Map country;
    @SerializedName("bank") public Map<String, String> bank;
    @SerializedName("code") public int code;

}
