package com.example.androidtest.java;

/**
 * 运行时, jvm 把Sample的信息都放入方法区
 */
public class Sample {
    /**
     * 范例名称
     */
    private String name;      //new Sample实例后， name 引用放入栈区里，  name 对象放入堆里

    static {
        System.out.print("Sample class loader");
    }


    /**
     * 构造方法
     */
    public Sample(String name) {
        this.name = name;
    }

    /**
     * print方法本身放入 方法区里。
     */
    public void printName() {
        System.out.println(name);
    }
}