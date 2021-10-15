package com.demo.ytl;

import java.util.Scanner;
import java.util.Stack;

/**
 * Main3
 *
 * @author gnl
 */

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().trim();

        char[] chars = str.toCharArray();

        StringBuilder builder = new StringBuilder();

        for (char c : chars) {
            if (c != ' ') {
                builder.append(c);
            }
        }

        String suffix = infix2suffix(builder.toString());
        System.out.println(suffix);
        int res = operated(suffix);
        System.out.println(res);
    }

    public static String infix2suffix(String infix) {
        Stack<Character> s = new Stack<>();
        String suffix = "";

        char[] chars = infix.toCharArray();
        for (char c : chars) {

            if (!isNumber(c)) {

                // 符号栈为空或者当前运算符优先级大于栈顶优先级的情况下，直接入栈
                if (s.isEmpty() || getPriority(c) > getPriority(s.peek())) {
                    s.push(c);
                } else {
                    // 符号栈不为空，且当前运算符优先级小于等于栈顶运算符优先级的情况下
                    // 先使用栈顶元素对数字栈中的元素进行运算，之后将运算结果如数字栈，再将当前运算符入符号栈
                    while (!s.isEmpty()) {
                        suffix += s.pop();
                    }
                    s.push(c);
                }

            } else {
                suffix += c;
            }

        }

        while (!s.isEmpty()) {
            suffix += s.pop();
        }

        return suffix;
    }

    // 322*+
    public static int operated(String suffix) {
        char[] chars = suffix.toCharArray();

        Stack<Integer> numStack = new Stack<>();

        for (char c : chars) {

            if (!isNumber(c)) {
                Integer a = numStack.pop();
                Integer b = numStack.pop();
                int res = doOperation(b, a, c);
                numStack.push(res);

            } else {
                numStack.push(c - '0');
            }
        }

        return numStack.pop();
    }

    public static int doOperation(Integer a, Integer b, char ch) {
        switch (ch) {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
        }

        return -1;
    }

    public static int getPriority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }

    }

    public static boolean isNumber(char c) {
        return (int) c >= 48 && (int) c <=57;
    }
}
