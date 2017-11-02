package com.az.testing.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.az.testing.mvp.view.MainActivityView;
import com.az.testing.repository.UserRepository;

/**
 * Created by zorin.a on 30.10.2017.
 */
@InjectViewState
public class MainActivityPresenter extends BasePresenter<MainActivityView> {

    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
