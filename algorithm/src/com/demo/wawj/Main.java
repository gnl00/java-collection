package com.demo.wawj;

/**
 * Main
 *
 * @author gnl
 * @date 2021-05-11 17:13
 */

public class Main {
    public static void main(String[] args) {
        int x = 6;
        int y = 8;
        x = x^y;
        y  =x^y;
        x = x^y;
        System.out.println(x);
        System.out.println(y);
    }
}
