package com.example.androidtest.activity;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader;

import java.io.InputStream;

/**
 */

public class MyGlideLoader extends BaseGlideUrlLoader {
    protected MyGlideLoader(ModelLoader concreteLoader) {

        super(concreteLoader);
    }

    @Override
    protected String getUrl(Object o, int width, int height, Options options) {
        return null;
    }

    @Override
    public boolean handles(Object o) {
        return false;
    }

    public static class Factory implements ModelLoaderFactory<String, InputStream> {
        @Override
        public ModelLoader<String, InputStream> build(MultiModelLoaderFactory multiFactory) {
            return null;
        }

        @Override
        public void teardown() {

        }
    }

}
