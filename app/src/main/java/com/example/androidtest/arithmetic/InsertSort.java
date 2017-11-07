package com.example.androidtest.arithmetic;

/**
 * 插入排序
 */
public class InsertSort extends BaseSort {

    public static void main(String[] args) {

        InsertSort sort = new InsertSort();
        sort.sort4();
//        sort.sort3();
//        sort.sort2();
//        sort.sort();

    }


    /**
     * 从前向后比较
     */
    @Override
    public void sort() {

        int temp;

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                temp = array[i];
                if (array[i] < array[j]) {
                    for (int k = i; k > j; k--) {
                        array[k] = array[k - 1];
                    }
                    array[j] = temp;
                }
            }
        }


        print();
    }

    /**
     * 从后想前比较，同sort3
     */
    public void sort2() {


        int temp, k;

        for (int i = 1; i < size; i++) {
            temp = array[i];
            k = i;
            for (int j = i - 1; j >= 0; j--) {
                if (temp < array[j]) {
                    array[j + 1] = array[j];
                    k = j;
                }
            }

            array[k] = temp;


        }

        print();
    }

    /**
     * 从后向前比较，元素一直后移，不交换
     */
    public void sort3() {
        int temp, j;

        for (int i = 1; i < size; i++) {
            temp = array[i];
            j = i - 1;
            //
            for (; j >= 0 && temp < array[j]; j--) {
                array[j + 1] = array[j];
            }

            array[++j] = temp;


        }

        print();
    }


    /**
     * 从后先前比较，交换次数较多
     */
    public void sort4() {
        int temp;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j - 1] <= array[j])
                    break;
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
        print();
    }

}
