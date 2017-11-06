package com.az.testing.repository;

import com.az.testing.api.ApiManager;
import com.az.testing.common.PrefManager;
import com.az.testing.network.request.LoginRequest;
import com.az.testing.network.response.CarsResponse;
import com.az.testing.network.response.LoginResponse;
import com.az.testing.network.response.ProfileResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by zorin.a on 30.10.2017.
 */

public class Repository {
    private PrefManager prefManager;
    private ApiManager apiManager;

    @Inject
    public Repository(ApiManager apiManager, PrefManager prefManager) {
        this.apiManager = apiManager;
        this.prefManager = prefManager;
    }

    public Observable<LoginResponse> login(LoginRequest request) {
        return apiManager.login(request);
    }

    public Observable<ProfileResponse> getUser(int imageDensity) {
        return apiManager.getUser(imageDensity);
    }

    public Observable<CarsResponse> getCars(int imageDensity, int limit, int offset) {
        return apiManager.getCars(imageDensity, limit, offset);
    }
}
