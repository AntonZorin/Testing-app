package com.az.testing.ui.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.az.testing.R;
import com.az.testing.mvp.presenter.MainFragmentPresenter;
import com.az.testing.mvp.view.MainFragmentView;
import com.az.testing.repository.UserRepository;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by zorin.a on 01.11.2017.
 */

public class MainFragment extends BaseFragment<MainFragmentPresenter> implements MainFragmentView {

    @InjectPresenter
    MainFragmentPresenter presenter;

    @Inject
    UserRepository userRepository;

    @BindView(R.id.fragment_main_image)
    ImageView imageView;

    public static MainFragment getNewInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getUserImage(11);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_main;
    }

    @ProvidePresenter
    MainFragmentPresenter providePresenter() {
        MainFragmentPresenter providedPresenter = new MainFragmentPresenter();
        providedPresenter.setUserRepository(userRepository);
        return providedPresenter;
    }

    @Override
    public void showUserImage(Bitmap image) {
        imageView.setImageBitmap(image);
    }
}
