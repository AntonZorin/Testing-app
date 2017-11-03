package com.az.testing.network.response;

import com.az.testing.network.model.ErrorModel;
import com.google.gson.annotations.SerializedName;

/**
 * Created by zorin.a on 03.11.2017.
 */

public class Response {
    @SerializedName("success")
    private boolean isSuccess;

    public ErrorModel getError() {
        return error;
    }

    public void setError(ErrorModel error) {
        this.error = error;
    }

    @SerializedName("error")
    private ErrorModel error;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
