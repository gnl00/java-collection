package com.demo.qunshuo;

/**
 * Main
 * 1. 先排序
 * 2. 去掉高低10%
 * 3. 求平均值，结果保留两位小数
 *
 * @author gnl
 */

public class Main {
    public static void main(String[] args) {

        int[] a = {33,45,30,95,68,67,56,84,77,100};

        sorted(a);

        double range = 0.1 * a.length;

        a = split(a, (int) range);

        double avg = avg(a);
        System.out.println(avg);

    }

    public static void sorted(int[] a) {

        boolean flag = false;
        int tmp = 0;
        for (int i = 1; i < a.length; i++) {
            int j = i-1;
            if (a[i] < a[j]) {
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                flag = true;
            }

        }

        while (flag) {
            sorted(a);
            break;
        }

    }

    public static int[] split(int[] a, int index) {
        int[] arr = new int[a.length - 2*index];

        int j = 0;
        for (int i = index; i < a.length - index ; i++) {
            arr[j++] = a[i];
        }

        return arr;

    }

    public static double avg(int[] a) {
        double sum = 0;
        for (int i : a) {
            sum += i;
        }
        return Double.parseDouble(String.format("%.2f", sum / a.length));
    }

}
