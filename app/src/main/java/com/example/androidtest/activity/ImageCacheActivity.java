package com.example.androidtest.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.androidtest.R;
import com.example.androidtest.hehonghuidemo.ImageLoader;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageCacheActivity extends AppCompatActivity implements ImageLoader.OnRefreshListener {

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
    @Bind(R.id.title2)
    TextView title2;
    @Bind(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

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
        imageLoader.mThread = Thread.currentThread();
        imageLoader.setOnRefreshListener(this);
        imageLoader.displayImage(url, imageView, title);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                imageLoader.displayImage(url, imageView, title);
            }
        });

        View s;

//        new Thread(new Test(title2)).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("new thread id:" + Thread.currentThread().getId());
                    Thread.sleep(1000);
                    title2.setText("new thread set textview");
//                } catch (RuntimeException e) {
//                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

//        new ImageUtil().displayImage(url,imageView);

    }

    class Test implements Runnable {

        private TextView textView;

        public Test(TextView textView) {
            this.textView = textView;
        }

        @Override
        public void run() {
            try {
                System.out.println("new thread id:" + Thread.currentThread().getId());
                Thread.sleep(1000);
                textView.setText("new thread set textview");
            } catch (RuntimeException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void init() {
        imageLoader = new ImageLoader();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public void onComplete() {
        refreshLayout.setRefreshing(false);
    }
}
