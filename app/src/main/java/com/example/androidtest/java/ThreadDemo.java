package com.example.androidtest.java;


public class ThreadDemo extends Thread {

    @Override
    public void run() {
        super.run();

        try {
            this.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

}
