package com.az.testing.network.response;

import com.az.testing.mvp.model.Car;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by zorin.a on 03.11.2017.
 */

public class CarsResponse extends Response {
    @SerializedName("cars")
    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
