package com.example.androidtest.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.androidtest.R;
import com.example.androidtest.hehonghuidemo.ImageLoader;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageCacheActivity extends AppCompatActivity {

    private static final String TAG = "ImageCacheActivity";
    ImageLoader imageLoader;
    @Bind(R.id.image_view)
    ImageView imageView;

    String url = "http://i-3.yxdown.com/2015/10/22/b6f85c77-2ae4-4480-a4de-e97cdc270e74.jpg";
    @Bind(R.id.glide_image)
    ImageView glideImage;

    ViewGroup c;
    @Bind(R.id.title)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_cache);
        ButterKnife.bind(this);

        Glide.with(this)
                .load(url)
                .into(glideImage);

        init();
        Log.i(TAG, "imageView is:" + imageView.toString());
        Log.i(TAG, "thread id:" + Thread.currentThread().getId());
        imageLoader.displayImage(url, imageView,title);
//        new ImageUtil().displayImage(url,imageView);

        Snackbar s;
    }


    private void init() {
        imageLoader = new ImageLoader();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}
