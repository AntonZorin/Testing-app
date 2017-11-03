package com.az.testing.ui.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.az.testing.R;
import com.az.testing.common.PrefManager;
import com.az.testing.mvp.model.Car;
import com.az.testing.mvp.model.User;
import com.az.testing.mvp.presenter.MainFragmentPresenter;
import com.az.testing.mvp.view.MainFragmentView;
import com.az.testing.repository.Repository;
import com.az.testing.ui.lists.adapter.CarsAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

/**
 * Created by zorin.a on 01.11.2017.
 */

public class MainFragment extends BaseFragment<MainFragmentPresenter> implements MainFragmentView {

    @InjectPresenter
    MainFragmentPresenter presenter;

    @Inject
    Repository repository;
    @Inject
    PrefManager prefManager;
    @Inject
    CarsAdapter carsAdapter;

    @BindView(R.id.fragment_main_user_image)
    ImageView imageView;
    @BindView(R.id.fragment_main_user_name_val)
    TextView userName;
    @BindView(R.id.fragment_main_user_surname_val)
    TextView userSurname;
    @BindView(R.id.fragment_main_user_age_val)
    TextView userAge;
    @BindView(R.id.fragment_main_user_cars)
    RecyclerView carList;

    public static MainFragment getNewInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        presenter.getUser();
        presenter.getCars();
    }

    private void initViews() {
        carList.setAdapter(carsAdapter);
        carList.setLayoutManager(new LinearLayoutManager(getActivity(), VERTICAL, false));
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_main;
    }

    @ProvidePresenter
    MainFragmentPresenter providePresenter() {
        MainFragmentPresenter providedPresenter = new MainFragmentPresenter();
        providedPresenter.setRepository(repository);
        providedPresenter.setPrefManager(prefManager);
        return providedPresenter;
    }

    @Override
    public void showUserImage(Bitmap image) {
        imageView.setImageBitmap(image);
    }

    @Override
    public void setUserData(User user) {
        userName.setText(user.getName());
        userSurname.setText(user.getSurName());
        userAge.setText(String.valueOf(user.getAge()));
        Picasso.with(getActivity()).load(user.getImage()).into(imageView);
    }

    @Override
    public void setUserCars(List<Car> cars) {
        carsAdapter.setData(cars);
    }
}
