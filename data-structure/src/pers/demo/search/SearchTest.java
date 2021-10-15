package pers.demo.search;

/**
 * SearchTest 查找算法测试
 *
 * @author gnl
 * @date 2021-04-22 16:13
 */

public class SearchTest {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        System.out.println(binarySearch(a, 0, a.length - 1, 40));
    }

    /**
     * binarySearch 二分查找，将找到的位置返回
     *
     * @param a
     * @param left
     * @param right
     * @param num
     * @return int
     * @author gnl
     */
    public static int binarySearch(int[] a, int left, int right, int num) {
        int mid = (left + right) / 2;

        if (num == a[mid]) {
            return mid;
        } else if (num < a[mid]) {
            // 关键字小于中点值，向左边查找
            while (mid - 1 != left ) {
                return binarySearch(a, 0, mid-1, num);
            }

            // 找到最左边的位置还未找到
            return -1;

        } else if (num > a[mid]){
            // 关键字大于中点值，向右边查找

            while (mid + 1 != right) {
                return binarySearch(a, mid + 1, right, num);
            }

            // 找到最右边的位置还未找到
            return -1;

        } else {
            // 未找到
            return -1;

        }

    }
}
