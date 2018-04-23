package com.example.androidtest.activity.launch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class BaseActivity2 extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate():" + log() + this.toString());
//        Log.i(TAG, "onCreate():");
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "onNewIntent():" + log() + this.toString());
//        Log.i(TAG, "onNewIntent():");
    }


    private String log() {

        StringBuilder sb = new StringBuilder();
        sb.append(" taskId:" + getTaskId() + " ");

        return sb.toString();
    }

}
