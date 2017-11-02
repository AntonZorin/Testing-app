package com.az.testing.api;

import android.graphics.Bitmap;

import com.az.testing.mvp.model.User;

import io.reactivex.Observable;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

/**
 * Created by zorin.a on 27.10.2017.
 */

public interface ApiService {
    @GET("/api/someFun")
    Observable<User> getUserData(int userId);

    @GET("/media_resources/globe_emea.png")
    Observable<ResponseBody> getImage();
}
