package com.example.androidtest.arithmetic;

/**
 * 选择排序
 * 时间复杂度O(n^2)
 * 空间复杂度O(n)
 * 每次找到剩余数里面的最大值或者最小值
 */
public class SelectionSort {

    private int[] array = {1, 3, 8, 9, 0, 1, 2, 4, 9, 5, 4, 3, 1};
    int size = array.length;

    public static void main(String[] args) {

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort();
    }

    private void sort() {

        for (int i = 0, k = 0; i < size; i++, k = i) {
            for (int j = i + 1; j < size; j++) {
                if (array[k] > array[j]) {//找到最小值
                    k = j;
                }
            }

            if (k != i) {
                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;
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
