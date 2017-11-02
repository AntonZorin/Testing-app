package com.az.testing.injection.module;

import com.az.testing.injection.scopes.ActivityScope;
import com.az.testing.ui.activity.BaseActivity;
import com.az.testing.ui.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by zorin.a on 27.10.2017.
 */

@Module(includes = AndroidSupportInjectionModule.class)
public interface AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = ActivityModule.class)
    MainActivity mainActivityInjector();
}
