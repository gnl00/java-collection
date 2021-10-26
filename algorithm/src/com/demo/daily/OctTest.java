package com.demo.daily;

import java.util.HashMap;
import java.util.Map;

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

        System.out.println("===========================================");

        int[][] b = {
                {1},
                {2, 3},
                {4, 5, 6},
                {7, 8, 9, 10}
        };

        Map<Integer, Integer> path = getMaxSumAndPath(b);
        System.out.println(path);
    }

    // 求出最大值
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

    // 求最大值与路径
    public static Map<Integer, Integer> getMaxSumAndPath(int[][] a) {
        Map<Integer, Integer> path = new HashMap<>();
        path.put(0, 0);

        int max = a[0][0];

        int i = 0;
        int j = 0;
        while (i < a.length - 1) {

            if (a[i + 1][j] > a[i + 1][j + 1]) {
                max += a[i + 1][j];
                path.put(i + 1, j);
            } else {
                max += a[i + 1][j + 1];
                path.put(i + 1, j + 1);
                j = j+1;
            }

            i = i+1;
        }

        System.out.println(max);

        return path;
    }

}
