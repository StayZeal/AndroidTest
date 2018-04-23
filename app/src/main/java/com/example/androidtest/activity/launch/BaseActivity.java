package com.example.androidtest.activity.launch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.androidtest.R;

import butterknife.OnClick;

public class BaseActivity extends AppCompatActivity {

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

    @OnClick({R.id.standard, R.id.singleTop, R.id.singleTask, R.id.singleInstance})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.standard:
                LaunchStandardActivity.startActivity(this);
                break;
            case R.id.singleTop:
                startActivity(new Intent(this, LaunchSingleTopActivity.class));
                break;
            case R.id.singleTask:
                startActivity(new Intent(this, LaunchSingleTaskActivity.class));
                break;
            case R.id.singleInstance:
                startActivity(new Intent(this, LaunchSingleInstanceActivity.class));
                break;
        }
    }
}
