package com.az.testing.ui.lists.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 *  Created by zorin.a on 30.10.2017.
 */
public class BaseViewHolder<T1 extends View> extends RecyclerView.ViewHolder {

    private T1 mItemView;

    public BaseViewHolder(T1 itemView) {
        super(itemView);
        this.mItemView = itemView;
    }

    public T1 getView() {
        return mItemView;
    }

    public void setView(T1 view) {
        mItemView = view;
    }
}
