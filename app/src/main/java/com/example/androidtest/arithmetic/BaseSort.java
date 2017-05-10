package com.example.androidtest.arithmetic;


public abstract class BaseSort {

    protected int[] array = {1, 3, 8, 9, 0, 1, 2, 4, 9, 5, 4, 3, 1};
    protected int size = array.length;

    protected void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public abstract void sort();

}
