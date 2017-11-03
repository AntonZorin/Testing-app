package com.az.testing.mvp.view;

import android.graphics.Bitmap;

import com.az.testing.mvp.model.Car;
import com.az.testing.mvp.model.User;

import java.util.List;

/**
 * Created by zorin.a on 01.11.2017.
 */

public interface MainFragmentView extends BaseMvpView {
    void showUserImage(Bitmap image);

    void setUserData(User user);

    void setUserCars(List<Car> cars);
}
