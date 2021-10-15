package com.demo.daily;

/**
 * BitOperationTest 位运算测试
 *
 * @author gnl
 */

public class BitOperationTest {

    public static void main(String[] args) {
        int [] array = {3,4,3,4,5,6,7,7,6};
        // single(array);

//        System.out.println(add(13, 9));
//        System.out.println(subtraction(5,3));
//        System.out.println(multi(5, 3));
//        System.out.println(division(10, 2));

        change(12, 32);
    }

    /**
     * 位运算实现加法，递归实现
     */
    public static int recursionAdd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            // 先异或
            int sum = a ^ b;
            // 再进行与，然后左移1位
            int carry = (a & b) << 1;
            return recursionAdd(sum, carry);
        }
    }

    /**
     * 位运算实现加法，非递归实现
     */
    public static int add(int a, int b) {
        int carry;
        while (b != 0) {
            carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    /**
     * 位运算实现减法
     */
    public static int subtraction(int a, int b) {
        b = ~b + 1;
        return add(a, b);
    }

    /**
     * 位运算实现乘法
     * @param a 被乘数
     * @param b 乘数
     * @return int
     */
    public static int multi(int a, int b) {
        int res = 0;
        // 1. 判断乘数是否为0，为0直接返回0
        while (b != 0) {
            // 确定末尾是1还是0
            if ((b & 1) == 1) {
                // 末尾为1，相加数是当前被乘数
                res += a;

                // 移位
                a = a << 1;
                b = b >> 1;
            } else {
                // 末尾为0，相加数为0
                // res += 0，res不用执行操作

                // 移位
                a = a << 1;
                b = b >> 1;
            }
        }
        return res;
    }

    /**
     * 位运算实现除法
     * @param a 被除数
     * @param b 除数
     * @return int
     */
    public static int division(int a, int b) {
        int res = 0;
        if (a < b) {
            return 0;
        } else {
            res = division(subtraction(a, b), b) + 1;
            return res;
        }
    }

    /**
     * 找出数组中只出现过一次的数
     */
    public static void single(int [] a) {
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            // 异或运算
            temp ^= a[i];
        }
        System.out.println(temp);
    }

    /**
     * 交换两个数
     */
    public static void change(int a, int b) {
        if (a != b) {
            a ^= b;
            b ^= a;
            a ^= b;
        }

        System.out.println(a);
        System.out.println(b);
    }

    public static void reverse(int a) {
        System.out.println(~a);
    }

}
