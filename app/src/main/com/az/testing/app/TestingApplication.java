package com.az.testing.app;

import com.az.testing.injection.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

/**
 * Created by zorin.a on 27.10.2017.
 */

public class TestingApplication extends DaggerApplication {

    public static TestingApplication INSTANCE;
    private Cicerone<Router> cicerone;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().context(getApplicationContext()).build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        initCicerone();
    }

    private void initCicerone() {
        cicerone = Cicerone.create();
    }

    public NavigatorHolder getNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }

    public Router getRouter() {
        return cicerone.getRouter();
    }
}
