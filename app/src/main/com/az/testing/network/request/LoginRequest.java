package com.az.testing.network.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zorin.a on 03.11.2017.
 */

public class LoginRequest {
    @SerializedName("login")
    private String login;
    @SerializedName("password")
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
