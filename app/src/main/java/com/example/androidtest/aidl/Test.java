package com.example.androidtest.aidl;

/**
 * Created by yangfeng on 2017/2/23.
 */
public class Test {

    public static void main(String[] args) {
        int[] a = {6, 7, 8, 4, 3, 2, 1};

        test(a);
    }

    public static void test(int[] s) {
        for (int i = 1; i < s.length; i++) {
            for (int j = s.length - 1; j >= i; j--) {
                if (s[j] > s[j - 1]) {
                    int temp = s[j - 1];
                    s[j - 1] = s[j];
                    s[j] = temp;
                }
            }
        }

        printLLL(s);
    }

    public static void printLLL(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


}
