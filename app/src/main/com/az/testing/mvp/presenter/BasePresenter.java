package com.az.testing.mvp.presenter;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;
import com.az.testing.app.TestingApplication;

import ru.terrakok.cicerone.Router;

/**
 * Created by zorin.a on 30.10.2017.
 */

public abstract class BasePresenter<View extends MvpView> extends MvpPresenter<View> {
    private Router router = TestingApplication.INSTANCE.getRouter();

    public void switchScreen(String screen, Object data) {
        if (data == null) {
            router.navigateTo(screen);
        } else {
            router.navigateTo(screen, data);
        }
    }

    public void newRootScreen(String screen, Object data) {
        if (data == null) {
            router.newRootScreen(screen);
        } else {
            router.newRootScreen(screen, data);
        }
    }

    public void returnToScreen(String screen) {
        router.backTo(screen);
    }

    public void onBack() {
        router.exit();
    }
}
