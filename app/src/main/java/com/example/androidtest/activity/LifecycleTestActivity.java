package com.example.androidtest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.androidtest.R;
import com.example.androidtest.adapter.VpAdaper2;
import com.example.androidtest.broadcastReceiver.PowerReceiver;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LifecycleTestActivity extends AppCompatActivity {

    private static final String TAG = "LifecycleTestActivity";
    PowerReceiver mPowerReceiver;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_test);
        ButterKnife.bind(this);
        Log.i(TAG, "onCreate");


      /*  mPowerReceiver = new PowerReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(mPowerReceiver, intentFilter);*/
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifecycleTestActivity.this, LifecycleTestActivity2.class);
                LifecycleTestActivity.this.startActivity(intent);
            }
        });


        viewPager.setAdapter(new VpAdaper2(getSupportFragmentManager(), null));
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
        if (mPowerReceiver != null) {
            unregisterReceiver(mPowerReceiver);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }
}
