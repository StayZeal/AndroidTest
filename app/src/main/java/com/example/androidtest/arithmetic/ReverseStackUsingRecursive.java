package com.example.androidtest.arithmetic;

import java.util.Stack;

/**
 * 一个栈一次压入了1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1.将这个栈转置后，
 * 从栈顶到栈底为1、2、3、4、5，
 * 也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构。
 */
public class ReverseStackUsingRecursive {


    /**
     * i = 1
     * i = 2
     * ...
     * i = 5 stack 5
     * i = 4 stack 5 4
     * i = 3 stack 5 4 3
     * i = 2 stack 5 4 3 2
     * i = 1 stack 5 4 3 2 1
     *
     *
     * @param stack
     */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);

        reverse(stack);
        stack.push(i);

        System.out.println("--------i------:" + i);
        for (int j = 0; j < stack.size(); j++) {
            System.out.print(stack.get(j));
        }
        System.out.println();
    }

    /**
     * 这个函数就是删除栈底元素并返回这个元素
     * result = 1 return 1;
     * last = 1 stack 2 return 1;
     * last = 1 stack 2 3 return 1;
     * last = 1 stack 2 3 4 return 1;
     * last = 1 stack 2 3 4 5 return 1;
     *
     * @param stack
     * @return
     */
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
//            System.out.println("栈顶：result:" + result);
//            for (int j = 0; j < stack.size(); j++) {
//                System.out.print(stack.get(j));
//            }
//            System.out.println();
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
//            System.out.println("last:" + last);
//            for (int j = 0; j < stack.size(); j++) {
//                System.out.print(stack.get(j));
//            }
//            System.out.println();
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        for (int j = 0; j < test.size(); j++) {
            System.out.print(test.get(j));
//            System.out.print(test.get(j));

        }
        System.out.println(" start...");
        reverse(test);
//        while (!test.isEmpty()) {
//            System.out.println(test.pop());
//        }

        System.out.print("result: ");
        for (int j = 0; j < test.size(); j++) {
            System.out.print(test.get(j));
        }

    }


}


