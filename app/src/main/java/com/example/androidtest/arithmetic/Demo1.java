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

    /**
     * 方法二：当字符串是流水字符串的时候，
     * 也就是字符串只能访问一次的时候，
     * 我们的标数组就应该保存字符串的小标了。
     *
     *
     * 字符串只遍历一次
     * @param tag
     */
    public static void func2(String tag){
        int[] flag = new int[256];
        for (int i = 0; i < flag.length; i++) {
            flag[i] = -1;
        }
        for (int i = 0; i < tag.length(); i++) {
            int index = tag.charAt(i);
            if (flag[index]  >= 0) {
                flag[index] = -2;//所有出现两次
            }else if(flag[index] == -1){
                flag[index] = i;//记录字符串只出现一次的位置.
            }
        }
        int min = 256;
        /**
         * 判断哪个第一次出现的字母最靠前
         */
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] < 0) {
                continue;
            }
            if (min > flag[i]) {
                min = flag[i];
            }
        }
        System.out.println(tag.charAt(min));
    }

}
