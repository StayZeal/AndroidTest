package com.example.androidtest.java;


public class SingleInstanceDemo {

    private SingleInstanceDemo() {
    }

    private static class SingleInstance {
        private static final SingleInstanceDemo mInstance = new SingleInstanceDemo();
    }

    public static SingleInstanceDemo getInstance() {
        return SingleInstance.mInstance;
    }


}
