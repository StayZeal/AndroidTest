package com.example.androidtest.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yangfeng on 2017/5/16.
 */

public class TestExecutor {

    public static void main(String[] args) {

        ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                throw new IllegalStateException("啦啦啦啦德玛西亚");
            }
        });
    }

}
