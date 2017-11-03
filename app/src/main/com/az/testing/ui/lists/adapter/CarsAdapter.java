package com.az.testing.ui.lists.adapter;

import android.view.ViewGroup;

import com.az.testing.mvp.model.Car;
import com.az.testing.ui.lists.item_view.CarItemView;
import com.az.testing.ui.lists.viewholder.BaseViewHolder;

import javax.inject.Inject;

/**
 * Created by zorin.a on 03.11.2017.
 */

public class CarsAdapter extends BaseAdapter<Car, CarItemView, BaseViewHolder<CarItemView>> {
    @Inject
    CarsAdapter() {

    }

    @Override
    public BaseViewHolder<CarItemView> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder<>(new CarItemView(parent.getContext()));
    }
}
