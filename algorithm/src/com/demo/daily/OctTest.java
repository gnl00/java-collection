package com.demo.daily;

public class OctTest {
    public static void main(String[] args) {
        int[][] a = {
                {1},
                {2, 3},
                {4, 5, 6},
                {7, 8, 9, 10}
        };

        int max = getMaxSum(a);
        System.out.println(max);
    }

    public static int getMaxSum(int[][] a) {
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    a[i][j] = a[i][j] + a[i-1][j];
                } else if (i == j) {
                    a[i][j] = a[i][j] +  a[i-1][j-1];
                } else {
                    a[i][j] = a[i][j] + Math.max(a[i-1][j], a[i-1][j-1]);
                }
                max = Math.max(max, a[i][j]);
            }
        }
        return max;
    }

    public static int getMaxSumAndPath(int[][] a) {
        int max = 0;
        int i = 0, j = 0;
        int x = 0, y = 0;
        while (i > a.length && j <= i) {

            i += 1;
            j = a[i][j] > a[i][j+1] ? j : j + 1;

        }

        return max;
    }
}
