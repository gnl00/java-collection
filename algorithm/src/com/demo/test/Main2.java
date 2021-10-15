package com.demo.test;

import java.util.Scanner;

/**
 * Main2
 *
 * @author gnl
 */

public class Main2 {
    public static String finalStr = "";
    public static String clipBoard = "";
    public static boolean selectAll = false;
    // 上一步的状态
    public static String stateBefore = "";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().trim();
        if (!"".equals(s) && null != s) {
            fun(s);
        }

    }

    public static void fun(String s) {
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                doOperation(ch + "");
                stateBefore = ch + "";
            }
            i++;
        }

        System.out.println(finalStr.length());
    }

    public static void doOperation(String s) {
        switch (s) {
            case "1":   // 输出
                if (selectAll) {
                    finalStr = s;
                    selectAll = !selectAll;
                } else {
                    finalStr += s;
                }
                break;
            case "2":   // 复制
                if (selectAll) {
                    clipBoard = finalStr;
                }
                break;
            case "3":   // 剪切
                if (selectAll) {
                    clipBoard = finalStr;
                    finalStr = "";
                }
                break;
            case "4":   // 粘贴

                if (!"".equals(clipBoard) && null != clipBoard) {

                    // 非第一次粘贴
                    if (stateBefore.equals("4")) {
                        finalStr += clipBoard;
                    } else {
                        // 第一次粘贴
                        finalStr = clipBoard;
                    }

                }
                break;
            case "5":   // 全选
                selectAll = !selectAll;
                break;
            default:
                break;
        }
    }
}
