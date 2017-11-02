package com.az.testing.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.az.testing.R;
import com.az.testing.common.Screens;
import com.az.testing.mvp.model.User;
import com.az.testing.mvp.presenter.MainActivityPresenter;
import com.az.testing.mvp.view.MainActivityView;
import com.az.testing.repository.UserRepository;

import javax.inject.Inject;

import static com.az.testing.common.Screens.MAIN_FRAGMENT_SCREEN;


public class MainActivity extends BaseActivity<MainActivityPresenter> implements MainActivityView {
    public static final String TAG = MainActivity.class.getSimpleName();

    @InjectPresenter(type = PresenterType.LOCAL)
    MainActivityPresenter presenter;

    @Inject
    UserRepository userRepository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.newRootScreen(MAIN_FRAGMENT_SCREEN, null);
    }

    @Override
    int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    @ProvidePresenter(type = PresenterType.LOCAL)
    public MainActivityPresenter providePresenter() {
        MainActivityPresenter providedPresenter = new MainActivityPresenter();
        providedPresenter.setUserRepository(userRepository);
        return providedPresenter;
    }

    @Override
    public void showUser(User user) {
        Log.v(TAG, "SHOW USER " + user.getName());
    }

    @Override
    public void showUserImage(Bitmap image) {
        ((ImageView) findViewById(R.id.image)).setImageBitmap(image);
    }
}