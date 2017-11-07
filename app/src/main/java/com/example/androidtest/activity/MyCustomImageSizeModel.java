package com.example.androidtest.activity;

import android.support.annotation.Nullable;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;

/**
 * Created by yangfeng on 2017/9/1.
 */

public class MyCustomImageSizeModel implements ModelLoader {
    @Nullable
    @Override
    public LoadData buildLoadData(Object o, int width, int height, Options options) {
        return null;
    }

    @Override
    public boolean handles(Object o) {
        return false;
    }
}
