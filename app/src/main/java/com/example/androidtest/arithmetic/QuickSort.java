package com.example.androidtest.arithmetic;

/**
 * 快速排序
 * 时间复杂度(n*log n)
 * 选中第一个数，大书房做，小书房有,从右边开始比较
 * 18641658371(min to max)
 * 1 8641658371 left = 1 right = 1 ;
 * (step 2)8
 * 1 8641658371 left = 1 right = 10 ;
 * 1 1641658371 left = 10 right = 10;
 * 1 164165837 8 left = 10 right = 10;
 * (step 3) 1
 * 1 164165837 8
 * 11 64165837 8
 * (step 4)6
 * 11 64165837 8 left = 2(6) right = 8(3);
 * 11 34165837 8 left =7(8) right = 8(3)
 * 11 34165887 8 left =7(8) right = 8(3)
 * 11 34165887 8 left = right = 7
 * 11 34165687 8
 * 11 34165 6 87 8
 * (step 5/8)(34165 sort and 87 sort)
 * 34165
 * 14165
 * 14465
 * 1 3 465
 * (step 6) sort 465
 * 1 3 4 65
 * (step 7) sort 65
 * 1 3 4 56
 * (step 8)
 * 87
 * 78
 *
 * 11 13456 6 78 8
 */
public class QuickSort {


    private int count = 0;

    /**
     * get first(left) num position.
     * @param datas
     * @param left
     * @param right
     * @return
     */
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
