package com.az.testing.injection.module;

import android.content.Context;

import com.az.testing.ApiManagerImpl;
import com.az.testing.api.ApiManager;
import com.az.testing.api.ApiService;
import com.az.testing.common.Constants;
import com.az.testing.common.PrefManager;
import com.az.testing.injection.scopes.ApplicationScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zorin.a on 30.10.2017.
 */
@Module
public class ApiModule {
    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(Constants.API_URL)
                .build();
    }

    @Provides
    @Singleton
    ApiManager provideApiManager(ApiService apiService, Context context, PrefManager prefManager) {
        return new ApiManagerImpl(apiService, context, prefManager);
    }

    @Provides
    @Singleton
    ApiService providesApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttp(Context context) {
        File cacheDir = new File(context.getCacheDir(), "http");
        Cache cache = new Cache(cacheDir, Constants.DISK_CACHE_SIZE);
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        return client;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }
}
