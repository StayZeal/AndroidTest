package com.example.androidtest.arithmetic;

/**
 * 快速排序
 */
public class QuickSort {


    private int count = 0;

    public int sort(int[] datas, int left, int right) {

//        System.out.println("sort left:" + left + " right:" + right);


        int temp = datas[left];
        ;
        while (left < right) {
            while (left < right && datas[right] >= temp)
                right--;
            datas[left] = datas[right];
            while (left < right && datas[left] <= temp)
                left++;
            datas[right] = datas[left];
        }
        datas[left] = temp;
        return left;
    }


    public void quickSort(int[] datas, int left, int right) {
//        System.out.println("quickSort left:" + left + " right:" + right);
        int position;
        if (left < right) {
            position = sort(datas, left, right);
            quickSort(datas, left, position - 1);
            quickSort(datas, position + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] datas = new int[]{3, 8, 4, 6, 2};

        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(datas, 0, datas.length - 1);

        for (int i = 0; i < datas.length; i++) {
            System.out.println(datas[i]);
        }
    }


}
