package com.example.androidtest.activity;

import android.os.Bundle;

import com.example.androidtest.R;

import butterknife.ButterKnife;

public class LaunchSingleTaskActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_single_task);
        ButterKnife.bind(this);
    }
}
