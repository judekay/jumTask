package com.judekayode.jumTask.models;

import com.judekayode.jumTask.api.response.BaseResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface CardSchemeApi {

    @Headers({
            "Content-Type: application/json"
    })
    @GET("{card_number}")
    Call<BaseResponse> binlookup(@Path("card_number") String cardNumber);

}
