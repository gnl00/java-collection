package com.demo.ytl;

import java.util.Scanner;

/**
 * Main1
 *
 * @author gnl
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }

        String str = "";

        int i = 0, j = 0;
        while ( i == 0 && j < m) {
            int sum = i + j;
            for (int k = 0; k < m; k++) {
                for (int l = 0; l < n; l++) {
                    if (k + l == i + j) {
                        str += a[k][l] + ",";
                    }
                }
            }
            j++;
        }

        while ( i <= n && j == m) {
            int sum = i + j;
            for (int k = 0; k < m; k++) {
                for (int l = 0; l < n; l++) {
                    if (k + l == i + j) {
                        str += a[k][l] + ",";
                    }
                }
            }
            i++;
        }

        System.out.println(str.substring(0, str.length()-1));

    }
}
