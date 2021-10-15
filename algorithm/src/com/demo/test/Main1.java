package com.demo.test;

import java.util.Scanner;

/**
 * Main1
 *
 * @author gnl
 */

public class Main1 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine().trim();
//        if ( !"".equals(s) && null != s) {
//            String[] split = s.split(" ");
//            int x = Integer.valueOf(split[0]);
//            int y = Integer.valueOf(split[1]);
//            if (0 < x && x <= (int) Math.pow(2, 50) -1 && 0 < y && y <= 5) {
//                fun(x, y);
//            }
//        }

        fun(2600, 1);

//        String reg = "^[a-z]\\D*";
//
//        System.out.println("0sfdf".matches(reg));
    }

    public static void fun(int x, int y) {
        if (x*y <= 26 *10) {
            System.out.println(1);
        }
    }
}
