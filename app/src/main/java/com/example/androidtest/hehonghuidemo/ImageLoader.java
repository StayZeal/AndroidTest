package com.example.androidtest.hehonghuidemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageLoader {

    private static final String TAG = "ImageLoader";
    LruCache<String, Bitmap> mImageCache;
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


    public ImageLoader() {
        initImageCache();
    }

    private void initImageCache() {
        final int maxMermory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMermory / 4;
        mImageCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String url, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    public void displayImage(final String url, final ImageView imageView, final TextView textView) {
        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(url);
                if (bitmap == null) {
                    Log.e(TAG, "bitmap is null!!!!");
                    return;
                }

                if (imageView.getTag().equals(url)) {
                    Log.i(TAG, "bitmap is:" + bitmap.toString());
                    Log.i(TAG, "imageView is:" + imageView.toString());
                    Log.i(TAG, "thread id before:" + Thread.currentThread().getId());
                    textView.setText("线程池中的数据");
                    imageView.setImageBitmap(bitmap);
                    Log.i(TAG, "thread id after:" + Thread.currentThread().getId());
                }
                bitmap.recycle();
                mImageCache.put(url, bitmap);
                Log.i(TAG, "thread id end");
            }
        });
    }

    public Bitmap downloadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

}
