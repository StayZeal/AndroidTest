package com.example.androidtest.activity.launch;

import android.os.Bundle;

import com.example.androidtest.R;

import butterknife.ButterKnife;

public class LaunchSingleTopActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_single_top);
        ButterKnife.bind(this);
    }


}
