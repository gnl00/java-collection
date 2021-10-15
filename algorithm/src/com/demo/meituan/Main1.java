package com.demo.meituan;

/**
 * Main1
 *
 * @author gnl
 */

public class Main1 {
    public static void main(String[] args) {
        String s1 = "asdf";
        String s2 = "qsdwe";

        int max = 0, count = 0;
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {

            if (s1.charAt(i) == s2.charAt(j)) {
                count++;
                i++;
                j++;
            } else {
                count = 0;
                j++;
            }

            if (i == s1.length() || j == s2.length()) {

                if (j == s2.length() && i < s1.length()) {
                    j = 0;
                    i++;
                }
                if (i == s1.length() && j < s2.length()) {
                    i = 0;
                    j++;
                }

            }
            max = max < count ? count:max;
        }

        System.out.println(max);
    }

    public static void test() {
        String s1 = "asdf";
        String s2 = "qsdwe";

        int max = 0, count = 0;

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {

                if (s1.charAt(i) == s2.charAt(j)) {
                    count++;
                } else {

                }

            }
        }

        System.out.println(max);
    }
}
