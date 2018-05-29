package com.judekayode.jumTask.api.response;

import java.util.Map;

public class CardSchemeResponse {

    private Boolean success;
    private Map<String, String> payload;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Map<String, String> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, String> payload) {
        this.payload = payload;
    }
}
