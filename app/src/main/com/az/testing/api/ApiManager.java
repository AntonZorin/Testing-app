package com.az.testing.api;

import android.graphics.Bitmap;

import com.az.testing.mvp.model.User;

import io.reactivex.Observable;

/**
 * Created by zorin.a on 27.10.2017.
 */

public interface ApiManager {
    Observable<User> getUserData(int userId);

    Observable<Bitmap> getUserImage(int id);
}
