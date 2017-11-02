package com.az.testing;


import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.az.testing.api.ApiService;
import com.az.testing.api.BaseApiManager;
import com.az.testing.mvp.model.User;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by zorin.a on 27.10.2017.
 */

public class ApiManagerImpl extends BaseApiManager {
    private final Context context;

    @Inject
    public ApiManagerImpl(ApiService service, Context context) {
        this.context = context;
        //strub
    }

    @Override
    public Observable<User> getUserData(int userId) {
        User user = new User();
        user.setId(231);
        user.setName("John");
        user.setImage("https://upload.wikimedia.org/wikipedia/commons/b/b7/John_Travolta_Deauville_2013_2.jpg");

        return Observable.just(user).compose(applySchedulers());
    }

    @Override
    public Observable<Bitmap> getUserImage(int id) {
        AssetManager assetManager = context.getAssets();

        InputStream istr = null;
        Bitmap bitmap = null;
        try {
            istr = assetManager.open("cat.jpg");
            bitmap = BitmapFactory.decodeStream(istr);
        } catch (IOException e) {
            // handle exception
        } finally {
            if (istr != null) {
                try {
                    istr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return Observable.just(bitmap);
    }
}
