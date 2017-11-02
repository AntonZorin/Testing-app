package com.az.testing.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.az.testing.mvp.view.MainFragmentView;
import com.az.testing.repository.UserRepository;

/**
 * Created by zorin.a on 01.11.2017.
 */

@InjectViewState
public class MainFragmentPresenter extends BasePresenter<MainFragmentView> {
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public void getUser(int userId) {
//        userRepository.getUserData(userId).subscribe(user -> {
//            getViewState().showUser(user);
//        });
//    }

    public void getUserImage(int userId) {
        userRepository.getUserImage(userId).subscribe(image -> {
            getViewState().showUserImage(image);
        });
    }


}
