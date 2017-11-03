package com.az.testing.api;

import com.az.testing.network.request.LoginRequest;
import com.az.testing.network.response.CarsResponse;
import com.az.testing.network.response.LoginResponse;
import com.az.testing.network.response.ProfileResponse;

import io.reactivex.Observable;

/**
 * Created by zorin.a on 27.10.2017.
 */

public interface ApiManager  {
    Observable<ProfileResponse> getUser(int imageDensity);

    Observable<LoginResponse> login(LoginRequest request);

    Observable<CarsResponse> getCars(int imageDensity, int limit, int offset);
}
