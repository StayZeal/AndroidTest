package com.example.androidtest.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by yangfeng on 2016/10/10.
 */
public class PowerReceiver extends BroadcastReceiver {

    private static final String TAG = "PowerReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        Log.i(TAG,"接收到广播");

        if (Intent.ACTION_SCREEN_OFF.equals(action)) {
            Log.i(TAG, "电源键关闭");
        } else if (Intent.ACTION_SCREEN_ON.equals(action)) {
            Log.i(TAG, "电源打开");

        }
    }
}
