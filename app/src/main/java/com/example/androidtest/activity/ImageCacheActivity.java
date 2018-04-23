package com.example.androidtest.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ViewTarget;
import com.example.androidtest.R;
import com.example.androidtest.hehonghuidemo.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageCacheActivity extends AppCompatActivity implements ImageLoader.OnRefreshListener {

    private static final String TAG = "ImageCacheActivity";
    ImageLoader imageLoader;
    @BindView(R.id.image_view)
    ImageView imageView;

    String url = "http://i-3.yxdown.com/2015/10/22/b6f85c77-2ae4-4480-a4de-e97cdc270e74.jpg";
    @BindView(R.id.glide_image)
    ImageView glideImage;

    ViewGroup c;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title2)
    TextView title2;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    Bitmap bitmap;
    Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_cache);
        ButterKnife.bind(this);

        RequestOptions options = new RequestOptions();

        options.fitCenter();

        ViewTarget viewTarget ;

        Glide.with(this)
                .load(url)
                .into(glideImage);



//        Glide.with(this)
//                .load(url)
//                .asBitmap()
//                .centerCrop()
//                .fitCenter()
//                .skipMemoryCache(true)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .dontAnimate()
//                .listener(new RequestListener<String, Bitmap>() {
//                    @Override
//                    public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                        return false;
//                    }
//
//                    @Override
//
//                    public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
//                        return false;
//                    }
//                })
//                .placeholder(0)
//                .error(0)//图片加载失败
//                .fallback(0)//返回的图片为null
//                .into(glideImage);

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
                } catch (RuntimeException e) {
                    e.printStackTrace();
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


    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
