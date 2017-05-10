package com.example.androidtest.arithmetic;

/**
 * Created by yangfeng on 2017/5/10.
 */

public class BubbleSort {

    private int[] array = {1, 3, 8, 9, 0, 1, 2, 4, 9, 5, 4, 3, 1};
    int size = array.length;


    public static void main(String[] args) {

        BubbleSort sort = new BubbleSort();
        sort.sort();
    }


    public void sort() {

        int temp;

        for (int i = 0; i < size; i++) {
            for (int j = 1; j < size - i; j++) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }

            }
        }

        print();

    }

    private void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }


}
