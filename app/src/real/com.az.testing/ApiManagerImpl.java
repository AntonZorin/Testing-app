package com.az.testing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.az.testing.api.ApiService;
import com.az.testing.api.BaseApiManager;
import com.az.testing.common.PrefManager;
import com.az.testing.mvp.model.User;
import com.az.testing.network.request.LoginRequest;
import com.az.testing.network.response.CarsResponse;
import com.az.testing.network.response.LoginResponse;
import com.az.testing.network.response.ProfileResponse;

import java.io.InputStream;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by zorin.a on 27.10.2017.
 */

public class ApiManagerImpl extends BaseApiManager {
    private final Context context;
    private final PrefManager prefManager;
    ApiService apiservice;

    @Inject
    public ApiManagerImpl(ApiService apiservice, Context context, PrefManager prefManager) {
        this.apiservice = apiservice;
        this.context = context;
        this.prefManager = prefManager;
    }

    @Override
    public Observable<LoginResponse> login(LoginRequest request) {
        return apiservice.login(request).compose(applySchedulers());
    }

    @Override
    public Observable<ProfileResponse> getUser(int imageDensity) {
        return apiservice.getUser(prefManager.getToken(), imageDensity).compose(applySchedulers());
    }

    @Override
    public Observable<CarsResponse> getCars(int imageDensity, int limit, int offset) {
        return apiservice.getCars(prefManager.getToken(), imageDensity, limit, offset).compose(applySchedulers());
    }
}
