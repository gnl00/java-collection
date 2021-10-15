package pers.demo.array;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ArrayTest
 *
 * @author gnl
 */

public class ArrayTest {
    public static void main(String[] args) {
        // int[] a = {1, 3, 5, 2, 4, 6, 8};

        // reverse(a, 0, a.length - 1);

        // moveFrontToLast(a, 3);

        //int[] split = split(a, 0, 2);

        // incrSort(a, 3, 3);


//        int[] x = {1,3,5,35};
//        int[] y = {2,4,6,8,9,10,11,34};
//        int[] mergeRes = mergeArrays(x, y);

        // sort(a, 3, 4);

//        for (int i : a) {
//            System.out.print(i + "\t");
//        }

//        int [] b = {9,4,3,11,2,6,10};
//        insertSort(b);
//
//        for (int i : b) {
//            System.out.print(i + "\t");
//        }


        int[] a = {1,2,3};
        // perm(a, new Stack());
         perm(a, 0);
//        perm(a, 0, a.length-1);

    }

    /**
     * perm 全排列

     * @return void
     * @author gnl
     */
    public static void perm(int[] a, Stack stack) {

        if (a.length <= 0) {
            System.out.println(stack);

        } else {
            for (int i = 0; i < a.length; i++) {

                int[] tmpArr = new int[a.length-1];
                System.arraycopy(a, 0, tmpArr, 0, i);
                System.arraycopy(a, i+1, tmpArr, i, a.length-(i+1));
                stack.push(a[i]);
                perm(tmpArr, stack);
                stack.pop();

            }
        }

    }

    public static Stack stack = new Stack();

    public static void perm(int[] a, int current) {

        if (current == a.length) {
            System.out.println(stack);
            return;
        }

        for (int i = 0; i < a.length; i++) {
            if (!stack.contains(a[i])) {
                stack.push(a[i]);
                perm(a, current+1);
                stack.pop();
            }
        }

    }

    public static void perm(int[] a, int start, int end) {
        if (start == end) {
            System.out.println(Arrays.toString(a));
        } else {

            for (int i = start; i <= end ; i++) {
                swap(a, start, i);
                perm(a, start+1, end);
                swap(a, start, i);
            }
            
        }
    }

    public static void swap(int[] a, int i, int j) {

        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;

    }

    /**
     * 包含重复元素的排列组合
     *
     * @author gnl
     */
    public static void repeated(List<String> list) {
        Stream<String> stream = list.stream();
        for (int n = 1; n < list.size(); n++) {
            stream = stream.flatMap(s -> list.stream().map(s::concat));
        }
        stream.collect(Collectors.toList()).forEach(System.out::println);
    }

    /**
     * unRepeated 不包含重复元素的排列组合
     *
     * @param list
     * @return void
     * @author gnl
     */
    public static void unRepeated(List<String> list) {
        Stream<String> stream = list.stream().distinct();
        for (int i = 1; i < list.size(); i++) {
            stream = stream.flatMap(str -> list.stream()
                    .filter(temp -> !str.contains(temp))
                    .map(str::concat));
        }
        stream.collect(Collectors.toList()).forEach(System.out::println);
    }

    /**
     * 数组a中，前n个元素有序递增，后m个元素也有序递增，将数组a调整为有序递增
     *
     * @param a
     * @param n
     * @param m
     * @return void
     * @author gnl
     * @date 2021/4/22 13:34
     */
    public static void sort(int[] a, int n, int m) {
        merge(a, 0, n-1, m+n-1);
    }

    public static void merge(int[] a, int low, int mid, int high) {

        int i = 0, j = 0;

        int index = low;

        int[] left = split(a, 0, mid);
        int[] right = split(a, mid + 1, high);

        while ( i < left.length && j < right.length) {

            if (left[i] <= right[j]) {
                a[index++] = left[i++];
            } else {
                a[index++] = right[j++];
            }

        }

        while ( i < left.length ) {
            a[index++] = left[i++];
        }

        while (j < right.length) {
            a[index++] = right[j++];
        }


    }

    /**
     * 求两个数组的差集
     * @param a
     * @param b
     * @return int[]
     * @author gnl
     */
    public static int[] diff(int[] a, int[] b) {
        return null;
    }

    /**
     * reverse 逆置
     * @param left 起始位置
     * @param right 终止位置
     * @return int[]
     * @author gnl
     */
    public static void reverse(int[] a, int left, int right) {

        int temp;
        for (int i = left, j = right; i < j; i++, j--) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

    }

    /**
     * moveFrontToLast 移动数组前端的n个元素到数组后端（只能使用原来的数组）
     * @param a
     * @param n
     * @author gnl
     */
    public static void moveFrontToLast(int[] a, int n) {

        reverse(a, 0, a.length - 1);
        reverse(a, 0, n - 1);
        reverse(a, n, a.length - 1);

    }


    /**
     * mergeArrays 合并两个递增数组，并保持元素递增排序
     * int[] x = {1,3,5,35}
     * int[] y = {2,4,6,8,9,10,11,34}
     *
     * @param a
     * @param b
     * @return void
     * @author gnl
     */
    public static int[] mergeArrays(int[] a, int[] b) {

        int index = 0, a_index = 0, b_index = 0;

        int[] arr = new int[a.length + b.length];

        while (a_index < a.length && b_index < b.length) {

            if (a[a_index] <= b[b_index]) {
                arr[index++] = a[a_index++];
            } else {
                arr[index++] = b[b_index++];
            }

        }

        while (a_index < a.length) {
            arr[index++] = a[a_index++];
        }

        while (b_index < b.length) {
            arr[index++] = b[b_index];
        }

        return arr;

    }

    /**
     * 直接插入排序
     *
     * @return void
     * @author gnl
     */
    public static void insertSort(int[] a) {

        int temp;
        for (int i = 1, j = i-1; i < a.length; i++, j++) {

            // 当前元素从后往前，与前面的元素一个个比较
            while (j > -1 && a[j] > a[i]) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;

                i--;
                j--;
            }
        }

    }

    /**
     * bubbleSort 冒泡排序
     * 平均时间复杂度为O(n^2)
     * @param a
     * @return void
     * @author gnl
     */
    public static void bubbleSort(int[] a) {

        // 记录此次排序有无交换，无交换则排序结束，有交换则继续下一轮排序
        boolean flag = false;

        int temp;
        for (int i = 1, j = i-1; i < a.length; i++, j++) {
            if (a[j] > a[i]) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                flag = true;
            }
        }

        if (flag) {
            bubbleSort(a);
        }

    }

    /**
     * 从n~m位置将原数组拆分成新数组
     * @param a
     * @param n
     * @param m
     * @return int[]
     * @author gnl
     */
    public static int[] split(int[] a, int n, int m) {

        int[] newArray = new int[m-n+1];
        int index = 0;
        for (int i = n; i <= m; i++) {
            newArray[index] = a[i];
            index++;
        }

        return newArray;
    }
}
