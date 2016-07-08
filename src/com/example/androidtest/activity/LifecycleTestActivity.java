package com.example.androidtest.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.androidtest.R;

public class LifecycleTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_test);
    }
}
