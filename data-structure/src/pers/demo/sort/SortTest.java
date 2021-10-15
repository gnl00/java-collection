package pers.demo.sort;


/**
 * SortTest 排序算法测试
 * 插入类：直接插入、二分插入、希尔排序
 * 交换类：冒泡排序、快速排序
 * 选择类：简单选择排序、堆排序
 * 归并类：二路归并排序
 * 基数类：基数排序
 *
 * @author gnl
 */

public class SortTest {
    public static void main(String[] args) {
        int[] a = {9, 4, 3, 11, 2, 6, 10};

        mergeSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i + "\t");
        }

    }

    /**
     * insertSort 直接插入排序
     * 平均时间复杂度 O(n^2)，空间复杂度O(1)
     *
     * @param a
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
     * 平均时间复杂度为O(n^2)，空间复杂度O(1)
     *
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

        while (flag) {
            bubbleSort(a);
            break;
        }

        /**
         * 对flag的判断也可用if-else

         if (flag) {
         bubbleSort(a);
         }

         */

    }

    /**
     * 快速排序
     * 平均时间复杂度为O(nlog2n)，空间复杂度O(log2n)
     *
     * @param a
     * @param left
     * @param right
     * @return void
     * @author gnl
     */
    public static void quickSort(int[] a, int left, int right) {

        if (left > right) {
            return;
        }

        int temp = a[left];
        int i = left, j = right;

        while (i != j) {

            // j一直向左扫描，直到找到小于等于temp的位置
            while (a[j] >= temp && i < j) {
                j--;
            }
            // 找到小于temp的元素，开始交换
            if ( i < j ) {
                a[i] = a[j];
            }

            // i一直向右扫描，直到找到大于temp的位置
            while (a[i] < temp && i < j) {
                i++;
            }
            if ( i < j) {
                a[j] = a[i];
            }

        }

        // 将temp放在最终位置
        a[i] = temp;
        quickSort(a, left, i-1);
        quickSort(a, i+1, right);
    }

    /**
     * 选择排序
     * 平均时间复杂度为O(n^2)，空间复杂度为O(1)
     *
     * @param a
     * @return void
     * @author gnl
     */
    public static void selectSort(int[] a) {

        int i, j, minIndex;
        int temp;

        for (i = 0; i < a.length; i++) {

            minIndex = i;

            // 循环找出最小值
            for (j = i+1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            // 最小值与第i个值交换
            temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }

    }

    /**
     * heapSort 堆排序
     * 时间复杂度O(nlog2n)，空间复杂度O(1)
     *
     * @param a
     * @param n
     * @return void
     * @author gnl
     */
    public static void heapSort(int[] a, int n) {

        int i;
        int temp;
        for (i = n/2; i >= 1 ; --i) {
            siftToMax(a, i, n);
        }
        for (i = n; i >= 2 ; --i) {
            temp = a[1];
            a[1] = a[i];
            a[i] = temp;
            siftToMax(a, 1, i-1);
        }

    }

    /**
     * siftToMax 调整为大顶堆。从下到上，从右到左调整 数组下标从1开始

     * @return void
     * @author gnl
     */
    public static void siftToMax(int[] a, int low, int high) {
        int i = low, j = i*2;
        int temp = a[i];
        while ( j<= high) {
            if (j < high && a[j]  <  a[j+1]) {
                ++j;
            }
            if (temp < a[j]) {
                a[i] = a[j];
                i = j;
                j = 2*i;
            } else {
                break;
            }
        }
        a[i] = temp;
    }

    /**
     * mergeSort 二路归并排序
     * 时间复杂度O(nlog2n)，空间复杂度O(n)
     * @param a
     * @param low
     * @param high
     * @return void
     * @author gnl
     */
    public static void mergeSort(int[] a, int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);
            merge(a, low, mid, high);
        }

    }

    /**
     * 将low~mid和mid+1~high有序的数组合并为整体有序的数组
     *
     * @param a
     * @param low
     * @param mid
     * @param high
     * @return void
     * @author gnl
     */
    public static void merge(int[] a, int low, int mid, int high) {

        int[] left = split(a, low, mid);
        int[] right = split(a, mid + 1, high);

        int i = 0,j = 0;

        // a的下标从low开始
        int index = low;

        while ( i < left.length && j < right.length) {

            if (left[i] <= right[j]) {
                a[index++] = left[i++];
            } else {
                a[index++] = right[j++];
            }
        }

        while (i < left.length) {
            a[index++] = left[i++];
        }

        while (j < right.length) {
            a[index++] = right[j++];
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
