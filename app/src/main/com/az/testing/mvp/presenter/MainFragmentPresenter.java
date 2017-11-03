package com.az.testing.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.az.testing.common.PrefManager;
import com.az.testing.mvp.view.MainFragmentView;
import com.az.testing.repository.Repository;

/**
 * Created by zorin.a on 01.11.2017.
 */

@InjectViewState
public class MainFragmentPresenter extends BasePresenter<MainFragmentView> {
    private Repository repository;
    private PrefManager prefManager;

    public void setRepository(Repository repository) {
        this.repository = repository;
    }


    public void setPrefManager(PrefManager prefManager) {
        this.prefManager = prefManager;
    }

    public void getUser() {
        repository.getUser(0).subscribe(user ->{
           getViewState() .setUserData(user.getUser());
        });
    }

    public void getCars() {
        repository.getCars(0,100,0).subscribe(cars ->{
            getViewState().setUserCars(cars.getCars());
        });
    }
}
