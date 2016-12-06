package com.example.androidtest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.androidtest.R;

public class LifecycleTestActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_test2);
    }
}
