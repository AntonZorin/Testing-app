package com.az.testing.common;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by zorin.a on 03.11.2017.
 */

public class PrefManager {
    private static final String PREFERENCES_NAME_KEY = "testing";

    private SharedPreferences sharedPreferences;

    @Inject
    public PrefManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME_KEY, 0);
    }

    public void seveToken(String token) {
        sharedPreferences.edit().putString("auth_token", token).apply();
    }

    public String getToken() {
        return sharedPreferences.getString("auth_token", "");
    }

    public void deleteToken() {
        sharedPreferences.edit().clear().apply();
    }
}
