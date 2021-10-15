package com.demo.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicReferenceTest
 * @author gnl
 */

public class AtomicReferenceTest {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(2021);

        /**
         * compareAndSet(期望值, 更新值)
         * 如果满足期望值，就将其更新为指定的更新值
         */
        System.out.println(integer.compareAndSet(2021, 2020));
        System.out.println(integer.get());

        // 不满足期望值，不会更新
        System.out.println(integer.compareAndSet(2021, 2022));
        System.out.println(integer.get());
    }
}
