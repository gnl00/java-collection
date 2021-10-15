package com.demo.meituan;

import java.util.Scanner;

/**
 * Main
 *
 * @author gnl
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String valuesStr = in.nextLine();

        String s = in.nextLine();
        String t = in.nextLine();

        String[] split = valuesStr.split(" ");
        int[] values = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            values[i] = Integer.valueOf(split[i]);
        }

        for (int value : values) {
            System.out.print(value + "\t");
        }


    }
}
