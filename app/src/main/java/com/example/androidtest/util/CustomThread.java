package com.example.androidtest.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by yangfeng on 2017/2/20.
 */
public class CustomThread extends Thread {

    private Handler mHandler;

    @Override
    public void run() {
        mHandler = new Handler(Looper.myLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };

        Looper.loop();
    }
}
