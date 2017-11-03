package com.az.testing.mvp.view;

import android.graphics.Bitmap;

import com.az.testing.mvp.model.User;

/**
 * Created by zorin.a on 30.10.2017.
 */

public interface MainActivityView extends BaseMvpView {
    void showUser(User user);

    void showToken(String token);
}
