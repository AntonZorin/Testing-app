package com.az.testing.api;

import com.az.testing.network.request.LoginRequest;
import com.az.testing.network.response.CarsResponse;
import com.az.testing.network.response.LoginResponse;
import com.az.testing.network.response.ProfileResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by zorin.a on 27.10.2017.
 */

public interface ApiService {
    @POST("/user/login")
    Observable<LoginResponse> login(@Body LoginRequest request);

    @GET("/user/profile")
    Observable<ProfileResponse> getUser(@Header("Authorization") String header, @Query("image_density") int imageDensity);

    @GET("/user/cars")
    Observable<CarsResponse> getCars(@Header("Authorization") String header, @Query("image_density") int imageDensity, @Query("limit") int limit, @Query("offset") int offset);
}
