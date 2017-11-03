package com.az.testing;


import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.az.testing.api.ApiService;
import com.az.testing.api.BaseApiManager;
import com.az.testing.common.PrefManager;
import com.az.testing.mvp.model.Car;
import com.az.testing.mvp.model.User;
import com.az.testing.network.request.LoginRequest;
import com.az.testing.network.response.CarsResponse;
import com.az.testing.network.response.LoginResponse;
import com.az.testing.network.response.ProfileResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by zorin.a on 27.10.2017.
 */

public class ApiManagerImpl extends BaseApiManager {
    private final Context context;


    @Inject
    public ApiManagerImpl(ApiService service, Context context, PrefManager prefManager) {

        this.context = context;
    }

    @Override
    public Observable<ProfileResponse> getUser(int imageDensity) {
        User user = new User();
        user.setId(54);
        user.setName("Вова");
        user.setSurName("Пупкин");
        user.setImage("https://www.w3schools.com/w3css/img_lights.jpg");
        user.setAge(48);
        user.setWeight(85);
        ProfileResponse profileResponse = new ProfileResponse();
        profileResponse.setUser(user);
        profileResponse.setSuccess(true);
        return Observable.just(profileResponse).compose(applySchedulers());
    }

    @Override
    public Observable<LoginResponse> login(LoginRequest request) {
        String token = "l;jsdjiotjowjdlfjrlsgk;sdr,gl[dfpgdf9o-09i345tlf0e4ujtlkfdsjljflgdhrh";
        LoginResponse response = new LoginResponse();
        response.setSuccess(true);
        response.setToken(token);
        return Observable.just(response).compose(applySchedulers());
    }

    @Override
    public Observable<CarsResponse> getCars(int imageDensity, int limit, int offset) {
        Car car1 = new Car();
        car1.setId(1);
        car1.setBrand("Honda");
        car1.setModel("Accord");
        car1.setImage("https://www.honda.com.au/content/dam/honda/cars/models/accordRel/Range_Pricing/16YM_Accord_V6L_LS_F34L.png");
        Car car2 = new Car();
        car2.setId(2);
        car2.setBrand("Mazda");
        car2.setModel("6");
        car2.setImage("http://fs.mazda.ru/mazda_ru/10a39b139fe6493fa5361a9caef9f151/Mazda3_SDN_Exterior_RQ_905x509.png");

        Car car3 = new Car();
        car3.setId(3);
        car3.setBrand("Mitsubishi");
        car3.setModel("Galant");
        car3.setImage("https://media.ed.edmunds-media.com/mitsubishi/galant/2001/oem/2001_mitsubishi_galant_sedan_gtz_rq_oem_1_500.jpg");

        List<Car> cars = new ArrayList<>(3);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        CarsResponse carsResponse = new CarsResponse();
        carsResponse.setSuccess(true);
        carsResponse.setCars(cars);
        return Observable.just(carsResponse).compose(applySchedulers());
    }
}
