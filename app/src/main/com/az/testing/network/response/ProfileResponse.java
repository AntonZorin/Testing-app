package com.az.testing.network.response;

import com.az.testing.mvp.model.User;
import com.google.gson.annotations.SerializedName;

/**
 * Created by zorin.a on 03.11.2017.
 */

public class ProfileResponse extends Response {
    @SerializedName("user")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
