package com.example.androidtest.util;

import android.os.AsyncTask;
import android.os.HandlerThread;

/**
 * Created by yangfeng on 2017/2/20.
 */
public class CustomHandlerThread extends HandlerThread {

    AsyncTask a;

    public CustomHandlerThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
    }
}
