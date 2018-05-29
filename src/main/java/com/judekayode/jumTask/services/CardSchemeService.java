package com.judekayode.jumTask.services;

import com.judekayode.jumTask.api.RetrofitConfiguration;
import com.judekayode.jumTask.api.response.BaseResponse;
import com.judekayode.jumTask.api.response.CardSchemeResponse;
import com.judekayode.jumTask.helpers.Constant;
import com.judekayode.jumTask.models.CardSchemeApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.HashMap;
import java.util.Map;

@Service
public class CardSchemeService {

    @Autowired
    private Environment env;

    public CardSchemeService(Environment env) {
        this.env = env;
    }

    public CardSchemeResponse getCardScheme(String cardPan) {
        try {
            String baseUrl = env.getProperty(Constant.CARD_SCHEME_BASE_URL);
            Retrofit retrofit = RetrofitConfiguration.cardSchemeApi(baseUrl);
            CardSchemeApi cardSchemeApi = retrofit.create(CardSchemeApi.class);

            Call<BaseResponse> call = cardSchemeApi.binlookup(cardPan);
            Response<BaseResponse> response = call.execute();

            if (response.code() != 200) {

                BaseResponse baseResponse = new BaseResponse();
                baseResponse.code = response.code();

                return handleResponse(baseResponse);
            }

            assert response.body() != null;
            response.body().code = 200;
            return handleResponse(response.body());

        } catch (Exception e) {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.code = 400;

            return handleResponse(baseResponse);
        }

    }

    private CardSchemeResponse handleResponse (BaseResponse baseResponse) {

        CardSchemeResponse cardSchemeResponse = new CardSchemeResponse();

        if (baseResponse.code != 200) {
            cardSchemeResponse.setSuccess(false);
            cardSchemeResponse.setPayload(null);

            return cardSchemeResponse;
        }

        cardSchemeResponse.setSuccess(true);
        Map<String, String> payload = new HashMap<>();
        payload.put("scheme", baseResponse.scheme);
        payload.put("type", baseResponse.type);
        payload.put("bank", baseResponse.bank.get("name"));

        cardSchemeResponse.setPayload(payload);

        return cardSchemeResponse;
    }
}
