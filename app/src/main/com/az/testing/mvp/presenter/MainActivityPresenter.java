package com.az.testing.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.az.testing.common.PrefManager;
import com.az.testing.mvp.view.MainActivityView;
import com.az.testing.network.request.LoginRequest;
import com.az.testing.repository.Repository;

/**
 * Created by zorin.a on 30.10.2017.
 */
@InjectViewState
public class MainActivityPresenter extends BasePresenter<MainActivityView> {

    private Repository repository;
    private PrefManager prefManager;

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public void setPrefManager(PrefManager prefManager) {
        this.prefManager = prefManager;
    }


    public void login() {
        LoginRequest request = new LoginRequest();
        request.setLogin("Ivanov");
        request.setPassword("3as24sd2");
        repository.login(request).subscribe(it ->{
           String token =  it.getToken();
           prefManager.seveToken(token);
           getViewState().showToken(token);
        });
    }
}
