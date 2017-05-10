package com.example.androidtest.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.example.androidtest.R;
import com.example.androidtest.customview.ZoomImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ZoomImageActivity extends AppCompatActivity {

    @Bind(R.id.zoom_Iv)
    ZoomImageView zoomIv;

    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_image);
        ButterKnife.bind(this);



        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bg);
//        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        zoomIv.setImageBitmap(bitmap);
    }
}
