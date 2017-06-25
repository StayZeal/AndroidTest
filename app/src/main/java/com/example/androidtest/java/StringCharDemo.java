package com.example.androidtest.java;



public class StringCharDemo {
    public static void main(String[] args) {
        String str = new String("abc");

        char[] ch = {'a', 'b', 'c'};

        change(str, ch);


        System.out.print(str + " ");

        System.out.print(ch);

    }

    public static void change(String str, char[] ch) {

        str = "ssss";

        ch[0] = 'd';

    }
}
