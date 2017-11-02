package com.az.testing.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.az.testing.R;
import com.az.testing.app.TestingApplication;
import com.az.testing.common.Screens;
import com.az.testing.mvp.presenter.BasePresenter;
import com.az.testing.ui.fragment.MainFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;
import dagger.android.support.HasSupportFragmentInjector;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.SupportAppNavigator;
import ru.terrakok.cicerone.commands.Command;

/**
 * Created by zorin.a on 30.10.2017.
 */

public abstract class BaseActivity<T extends BasePresenter> extends MvpAppCompatActivity
        implements HasFragmentInjector, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<android.support.v4.app.Fragment> supportFragmentInjector;
    @Inject
    DispatchingAndroidInjector<android.app.Fragment> frameworkFragmentInjector;

    private Navigator navigator = new SupportAppNavigator(this, R.id.container) {
        @Override
        protected Intent createActivityIntent(String screenKey, Object data) {
            return null;
        }

        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey) {
                case Screens.MAIN_FRAGMENT_SCREEN:
                    return MainFragment.getNewInstance();
            }
            return null;
        }

        @Override
        protected void setupFragmentTransactionAnimation(
                Command command,
                Fragment currentFragment,
                Fragment nextFragment,
                FragmentTransaction fragmentTransaction) {
            //setup animation
        }
    };
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
      bindViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        TestingApplication.INSTANCE.getNavigatorHolder().setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        TestingApplication.INSTANCE.getNavigatorHolder().removeNavigator();
    }

    @Override
    protected void onDestroy() {
        unBindViews();
        super.onDestroy();
    }

    private void bindViews() {
        setContentView(getLayoutRes());
        unbinder = ButterKnife.bind(this);
    }

    private void unBindViews() {
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override
    public AndroidInjector<android.support.v4.app.Fragment> supportFragmentInjector() {
        return supportFragmentInjector;
    }

    @Override
    public AndroidInjector<android.app.Fragment> fragmentInjector() {
        return frameworkFragmentInjector;
    }

    abstract int getLayoutRes();

    abstract T providePresenter();
}
