package com.az.testing;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;

import com.az.testing.api.ApiService;
import com.az.testing.app.TestingApplication;
import com.az.testing.common.Constants;
import com.az.testing.common.PrefManager;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.junit.Before;
import org.junit.runner.RunWith;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zorin.a on 03.11.2017.
 */
@RunWith(AndroidJUnit4.class)
public class BaseTest {
    protected Context context;
    protected ApiService apiService;
    protected PrefManager prefManager;


    @Before
    public void setUp() throws Exception {
        context = TestingApplication.INSTANCE.getApplicationContext();
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .baseUrl(Constants.API_URL)
                .build();
        apiService = retrofit.create(ApiService.class);
        prefManager = new PrefManager(context);
    }
}
