package com.az.testing.injection.component;

import android.content.Context;

import com.az.testing.app.TestingApplication;
import com.az.testing.injection.module.ActivityModule;
import com.az.testing.injection.module.ApiModule;
import com.az.testing.injection.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;

/**
 * Created by zorin.a on 27.10.2017.
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent extends AndroidInjector<TestingApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder context(Context context);

        AppComponent build();
    }
}
