package com.example.androidtest.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.androidtest.R;

public class AidlClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl_client);

        Button mButton = null;
        ObjectAnimator.ofInt(mButton, "width", 500).setDuration(5000).start();
    }
}
