package com.demo.compare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ComparatorTest
 *
 * @author gnl
 */

public class ComparatorTest {
    public static void main(String[] args) {
        String[] arr = new String[] {"QW", "AS", "ZX", "ER", "DF", "CV"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    return o1.compareTo(o2);
                }
                throw new RuntimeException("比较数据类型异常");
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}
