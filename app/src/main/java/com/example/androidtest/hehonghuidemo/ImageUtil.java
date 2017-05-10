package com.example.androidtest.hehonghuidemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by yangfeng on 2017/2/27.
 */
public class ImageUtil {


    private static final String TAG = "ImageUtil";

    public void displayImage(final String url, final ImageView imageView) {
        imageView.setTag(url);
        new Thread(new Runnable() {
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
                    imageView.setImageBitmap(bitmap);
                    Log.i(TAG, "thread id after:" + Thread.currentThread().getId());
                }
                bitmap.recycle();
                Log.i(TAG, "thread id end");
            }
        }).start();
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
