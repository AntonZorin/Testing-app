package com.az.testing.repository;

import android.graphics.Bitmap;

import com.az.testing.api.ApiManager;
import com.az.testing.mvp.model.User;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by zorin.a on 30.10.2017.
 */

public class UserRepository {
    ApiManager apiManager;

    @Inject
    public UserRepository(ApiManager apiManager) {
        this.apiManager = apiManager;
    }

    public Observable<User> getUserData(int id) {
        return apiManager.getUserData(id);
    }

    public Observable<Bitmap> getUserImage(int id) {
        return apiManager.getUserImage(id);
    }
}
