package com.example.androidtest;


import android.app.Application;

import com.hook.HookUtil;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        new HookUtil().hookAms();
    }
}
