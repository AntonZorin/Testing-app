package com.az.testing.network.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zorin.a on 03.11.2017.
 */

public class ErrorModel {
    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
