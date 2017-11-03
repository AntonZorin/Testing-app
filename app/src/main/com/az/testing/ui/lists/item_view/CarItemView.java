package com.az.testing.ui.lists.item_view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.az.testing.R;
import com.az.testing.mvp.model.Car;
import com.az.testing.mvp.view.ViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zorin.a on 03.11.2017.
 */

public class CarItemView extends ConstraintLayout implements ViewModel<Car> {
    @BindView(R.id.cat_item_title)
    TextView title;

    public CarItemView(Context context) {
        super(context);
        init();
    }

    public CarItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CarItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view = inflate(getContext(), R.layout.view_car, this);
        ButterKnife.bind(view);
    }

    @Override
    public void setData(Car data) {
        title.setText(data.getModel());
    }

}
