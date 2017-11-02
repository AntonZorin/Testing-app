package com.az.testing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.az.testing.api.ApiService;
import com.az.testing.api.BaseApiManager;
import com.az.testing.mvp.model.User;

import java.io.InputStream;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by zorin.a on 27.10.2017.
 */

public class ApiManagerImpl extends BaseApiManager {
    private final Context context;
    ApiService apiservice;

    @Inject
    public ApiManagerImpl(ApiService service, Context context) {
        apiservice = service;
        this.context = context;
    }

    @Override
    public Observable<User> getUserData(int userId) {
        return apiservice.getUserData(userId).compose(applySchedulers());
    }

    @Override
    public Observable<Bitmap> getUserImage(int id) {
        return apiservice.getImage().compose(applySchedulers()).map(resp -> {
            final InputStream inputStream = resp.byteStream();
            Bitmap bmp = BitmapFactory.decodeStream(inputStream);
            return bmp;
        });
    }
}
