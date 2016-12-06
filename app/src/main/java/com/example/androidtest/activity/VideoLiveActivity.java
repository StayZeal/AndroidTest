package com.example.androidtest.activity;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;

import com.example.androidtest.R;

public class VideoLiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_live);
    }



    private void init(){
        ParcelFileDescriptor parcelFileDescriptor = ParcelFileDescriptor.fromSocket(null);
        parcelFileDescriptor = ParcelFileDescriptor.fromDatagramSocket(null);
    }

}
