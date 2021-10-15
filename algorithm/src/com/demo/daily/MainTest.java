package com.demo.daily;

import java.util.*;

/**
 * MainTest
 *
 * @author gnl
 */

public class MainTest {
    public static void main(String[] args) {
        Goods g = new Goods(3000, 4);
    }

    public static void backpack(int[] a) {

        int[] f = new int[a.length + 1];
        a[0] = 0;
        for (int i = 1; i <= a.length ; i++) {

        }

    }

    static class Goods {
        int price;
        int weight;

        public Goods(int price, int weight) {
            this.price = price;
            this.weight = weight;
        }
    }

    // 青蛙能否跳到最后一个（n-1）石头
    public static void jump(int[] a) {
        // 初始状态
        int i = 0;
        boolean flag = true;
        while (i < a.length) {
            int current = i + a[i];
            if (current <= i) {
                flag = !flag;
                break;
            } else {
                i = current;
            }
        }
        System.out.println(flag);
    }

    // 机器人在m*n的格子中只能向左或者向下，走到终点的方式总数
    public static int ways(int m, int n) {
        int [][] f = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                } else {
                    f[i][j] = f[i-1][j] + f[i][j-1];
                }
            }
        }
        System.out.println(f[m-1][n-1]);
        return f[m-1][n-1];
    }

    // 最少需要多少枚硬币n，总和等于m
    public static int coinCount(int[] coins, int m) {

        if (m == 0) {
            return 0;
        } else {
            int[] a = new int[m + 1];
            for (int i = 1; i <= m ; i++) {
                // 表示无法用数组中的硬币表示总数
                a[i] = Integer.MAX_VALUE;

                // 对每种硬币进行循环
                for (int j = 0; j < coins.length; j++) {
                    if (i - coins[j] >= 0 && a[i - coins[j]] != Integer.MAX_VALUE) {
                        a[i] = Math.min(a[i], a[i - coins[j]] + 1);
                    }
                }
            }
            if (a[m] == -1) {
                return -1;
            }
            return a[m];
        }

    }
}

/**
 * {商品1}\t{数量1}\n{商品2}\t{数量2}\n...{商品n}\t{数量n}\n
 * 数量可能是 0x 开头的16进制非负整数，也可能是一般的10进制非负整数
 * 这一行最后的两个字符"\n" 可能有，也可能没有，都是合法的输入
 * 输入长度不超过 1000000
 *
 * 输入：
 * 晨光AFPM0801\t0x2\n斑马小楷\t40\n
 * 输出：
 * 晨光AFPM0801,2
 * 斑马小楷,40
 *
 */
class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        //  \\n 转义为 \n
        s = s.replace("\\n", " ");

        String[] strings = s.split(" ");

        // 匹配0x开头，后面任意为都是数字的字符串
        String suffixHexReg = "0x\\d*";
        // 匹配都是数字的字符串
        String suffixNumReg = "\\d*";

        for (String string : strings) {

            //  \\t 转义为 \t
            string = string.replace("\\t", ",");
            int split_index = string.indexOf(",");

            String suffix = string.substring(split_index + 1);

            if (suffix.matches(suffixHexReg) || suffix.matches(suffixNumReg)) {

                if (suffix.matches(suffixHexReg)) {
                    String newSuffix = hexTransform(suffix);

                    string = string.replace(suffix, newSuffix);
                }

                System.out.println(string);

            } else {
                throw new RuntimeException("非法字符串");
            }

        }

        // System.out.println("\\n");
    }

    public static String hexTransform(String hexStr) {

        if (hexStr.startsWith("0x")) {
            hexStr = hexStr.replace("0x", "");
        }

        return Integer.valueOf(hexStr, 16).toString();

    }
}

// 匹配括号，找出成对括号，并给出对应的左右括号下标
class Test3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        qStack(str);
    }

    public static void qStack(String s) {
        Stack stack = new Stack();
        Stack<Integer> indexStack = new Stack();

        // String to CharArray
        char[] a = s.toCharArray();

        // count brackets
        int count = 0;

        // string to storage bracket's index
        StringJoiner indexStr = new StringJoiner(",");

        // pointer
        int i = 0;

        while (i < a.length) {
            if ("(".equals(String.valueOf(a[i]))) {
                stack.push(a[i]);
                indexStack.push(i);

            } else if (")".equals(String.valueOf(a[i]))){
                if (String.valueOf(stack.peek()).equals("(")) {
                    stack.pop();


                    indexStr.add(i+"");
                    indexStr.add(indexStack.peek()+"");

                    count++;
                }
            }
            i++;
        }

        // array to output bracket's index
        String[] split = new StringBuilder(indexStr.toString()).reverse().toString().split(",");

        System.out.println(count);

        for (int j = 0; j < split.length; j++) {
            System.out.println(split[j]);
        }

    }
}
