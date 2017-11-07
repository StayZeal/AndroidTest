package com.example.androidtest.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫环问题
 * eg.标号1-n的n个人首尾相接，1到3报数，报到3的退出，求最后一个人的标号
 * 3 6 9 12 15 4 8 13 2 10 1 11 7 14 5
 * 3 6 9 12 15 4 8 13 2 10 1 11 7 14 5
 */
public class Yue {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("请输入总人数：");
//        int totalNum = scanner.nextInt();
//        System.out.print("请输入报数的大小：");
//        int cycleNum = scanner.nextInt();
//        yuesefu(totalNum,0, cycleNum);
//        scanner.close();

        calc(15, 3, 0, null);
    }

    /**
     *
     * @param totalNum
     * @param start    从第start个编号开始计数,代表位置
     * @param out
     */
    public static void yuesefu(int totalNum,int start, int out) {
        // 初始化人数15

        List<Integer> datas = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            datas.add(i);
        }

//        int k = 0;
        while (datas.size() > 0) {
            start = start + out;
            // 第m人的索引位置
            start = start % (datas.size()) - 1;
            // 判断是否到队尾
            if (start < 0) {
                System.out.print(datas.get(datas.size() - 1)+" ");
                datas.remove(datas.size() - 1);
                start = 0;
            } else {
                System.out.print(datas.get(start)+" ");
                datas.remove(start);
            }
        }
    }


    /**
     *  递归方法
     * @param total
     * @param out
     * @param start  开始的位置
     * @param datas
     * @param count
     */
    public static void calc(int total, int out, int start, List<Integer> datas, int... count) {
        int temp;
        if (datas == null) {
            count = new int[]{1};
            datas = new ArrayList<Integer>();
            for (int i = 0; i < total; i++) {
                datas.add(i + 1);
            }
        } else if (datas.size() == 1) {
            System.out.println("第" + count[0] + "轮开始：" + datas);
            System.out.println("第" + count[0] + "轮结束：" + datas);
            return;
        }
//        System.out.println("第" + count[0] + "轮开始：" + array);
        start = start + out;
        // 第m人的索引位置
        start = start % (datas.size()) - 1;

        // 判断是否到队尾
        if (start < 0) {
            temp = datas.get(datas.size() - 1);
//            System.out.print(datas.get(datas.size() - 1)+" ");
            datas.remove(datas.size() - 1);
            start = 0;
        } else {
            temp = datas.get(start);
//            System.out.print(datas.get(start)+" ");
            datas.remove(start);
        }
        System.out.println("第" + count[0] + "轮结束：" + datas + " out:" + temp);
        count[0] += 1;
        calc(datas.size(), out, start, datas, count);
    }
}