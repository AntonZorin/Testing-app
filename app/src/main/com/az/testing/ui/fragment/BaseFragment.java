package com.az.testing.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.az.testing.mvp.presenter.BasePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by zorin.a on 01.11.2017.
 */

public abstract class BaseFragment<T extends BasePresenter> extends MvpAppCompatFragment {

    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return bindViews(inflater, container);
    }

    @Override
    public void onDestroy() {
        unBindViews();
        super.onDestroy();
    }

    private View bindViews(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(getLayoutRes(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private void unBindViews() {
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    public abstract int getLayoutRes();

    abstract T providePresenter();
}
