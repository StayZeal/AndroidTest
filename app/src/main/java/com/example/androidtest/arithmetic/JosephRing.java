package com.example.androidtest.arithmetic;

import java.util.ArrayList;
import java.util.List;


/**
 * 约瑟夫环问题
 * eg.标号1-n的n个人首尾相接，1到3报数，报到3的退出，求最后一个人的标号
 */

public class JosephRing {
    public static void main(String[] args) {
        calc(15, 3, 1, null);
        calc2(15, 3, 1, null);
    }

    /**
     * 递归方式的算法
     *
     * @param total
     * @param out
     * @param start
     * @param array
     * @param count
     */
    public static void calc(int total, int out, int start, List<Integer> array, int... count) {
        int temp;
        if (array == null) {
            count = new int[]{1};
            array = new ArrayList<Integer>();
            for (int i = 0; i < total; i++) {
                array.add(i + 1);
            }
        } else if (array.size() == 1) {
            System.out.println("第" + count[0] + "轮开始：" + array);
            System.out.println("第" + count[0] + "轮结束：" + array);
            return;
        }
//        System.out.println("第" + count[0] + "轮开始：" + array);
        //记录出去的位置
        start = (start + out - 1) > total ? (start + out - 1) / total : start + out - 1;
        temp = array.get(start - 1);
        array.remove(start - 1);
        System.out.println("第" + count[0] + "轮结束：" + array + " out:" + temp);
        count[0] += 1;
        calc(--total, out, start, array, count);
    }

    /**
     * 非递归方式的算法
     *
     * @param total
     * @param out
     * @param start
     * @param array
     * @param count
     */
    public static void calc2(int total, int out, int start, List<Integer> array, int... count) {
        int temp;
        if (array == null) {
            array = new ArrayList<>();
            for (int i = 0; i < total; i++) {
                array.add(i + 1);
            }
        }


        while (array.size() > 1) {
            start = (start + out - 1) > total ? (start + out - 1) / total : start + out - 1;
            temp = array.get(start - 1);
            array.remove(start - 1);
            total--;

            System.out.print(temp + " ");
        }

        System.out.print(array.get(0));

    }
}