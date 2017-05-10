package com.example.androidtest.java;


import java.util.ArrayList;
import java.util.List;

public class Bill {

    public float[] bills = new float[]{
            85,
            36.9f,
            9.49f,
            27,
            12,
            28.8f,
            14f,
            145,
            51,
            28.3f,
            38.9f,
            18.8f,
            17f,
            18.08f,
            18.8f,
            15f,
            10.41f,
            18.8f,
            14,
            25.8f,
            198,
            15.8f,
            9.9f,
            27f,
            295f,
            //-68f,
            1676.74f,
            45.27f,
            13.4f,
            2160,//健身
            2160,//健身
            26,
            13.14f,
            18.8f,
            9.9f,
            21.8f,
            13.4f,
            28.8f,
            10.9f,
            10, 9.5f,
            78,
            249,
            19,
            13,
            9.14f,
            662f,//请吃饭
            17,
            14.9f, 18.8f, 11.3f, 17.9f, 7.8f, 19f, 18.8f, 19.2f, 21.4f,
            3,
            34.9f,
            17,
            397,//买衣服
            18.9f,
            990f,//机票
            15.8f,
            //-5030.22,
            2.5f,
            10


    };

    public List<Float> costs = new ArrayList();

    public void sum() {
        float sum = 0;
        for (int i = 0; i < bills.length; i++) {
            sum += bills[i];
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {
        Bill bill = new Bill();
        bill.sum();

    }


}
