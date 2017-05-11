package com.example.androidtest.arithmetic;

/**
 * 给定一个字符串，求第一个不重复的字符 abbcad -> c
 */

public class Demo1 {

    public static void main(String[] args) {

        String s = "abcdefg";
        firstUnRepeat(s);
        firstNotRepeatingChar(s);

    }


    public static void firstUnRepeat(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        char c;
        int count, num = 0;
        for (int i = 0; i < size; i++) {
            num = i;
            c = chars[i];
            count = 0;
            for (int j = 0; j < size; j++) {

                //减少比价次数
                if (count == 2) {
                    break;
                }

                if (c == chars[j]) {
                    count++;
                }
            }

            if (count == 1) {
                break;
            }
        }
        System.out.println(chars[num]);
    }


    public static void firstNotRepeatingChar(String str) {
        int[] hash_table = new int[256];

        if (str.isEmpty()) {
            return;
        }

        int len = str.length();
        int i = 0;

        for (i = 0; i < len; i++) {
            System.out.println((int) str.charAt(i));
            hash_table[str.charAt(i)]++;
        }

        for (i = 0; i < len; i++) {
            if (hash_table[str.charAt(i)] == 1) {
                System.out.print(str.charAt(i));
                break;
            }
        }


    }
}
