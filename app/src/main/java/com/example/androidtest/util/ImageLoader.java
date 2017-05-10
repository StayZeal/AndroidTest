package com.example.androidtest.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.LruCache;
import android.widget.ImageView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ImageLoader {

    private static final int DISK_CACHE_SIZE = 4 * 1024 * 1024;
    Map<String, Bitmap> mermroyCache = new HashMap<>();

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bitmap bitmap = (Bitmap) msg.obj;
        }
    };

    LruCache diskCache = new LruCache(DISK_CACHE_SIZE) {

        protected int sizeOf(String key, Bitmap value) {
            return value.getByteCount();
        }
    };


    public void load(String url, ImageView imageView) {
        Bitmap bitmap = mermroyCache.get(url);
        if (bitmap == null) {

        }
    }

    private void loadFormDisk(String url, ImageView imageView) {

    }

    private void putIntoDisk(String url, Bitmap bitmap) {
        diskCache.put(url, bitmap);
    }


    private void loadFromHttp(String path, Handler handler) {

//        URL url = new URL(path);
        HttpURLConnection connection = null;
        try {
            URL url = new URL(path);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(path)));
//            int count = 0;
//            byte[] bytes = new byte[1024];
//            int position = 0;
//            while ((count = dataInputStream.read(bytes, position, 1024)) > 0) {
//                position += count;
//                dataOutputStream.write(bytes);
//                dataOutputStream.write(bytes, position, 1024);
//            }

            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            Message message = Message.obtain();
            message.obj = bitmap;
            handler.sendMessage(message);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

    }


}
