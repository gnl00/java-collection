package com.demo.juc;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * CASTest
 * @author gnl
 */

public class CASTest {
    public static void main(String[] args) {
        /**
         * AtomicStampedReference 带乐观锁的原子引用
         * @param initialRef 初始引用值
         * @param initialStamp 初始版本
         */
        AtomicStampedReference<Integer> integerRef = new AtomicStampedReference<>(1, 1);

        System.out.println("ref: " + integerRef.getReference());
        System.out.println("stamp: " + integerRef.getStamp());

        new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "\tupdate now");
            /**
             * compareAndSet(期望值, 新值, 期望版本, 新版本)
             */
            System.out.println(integerRef.compareAndSet(1, 2, integerRef.getStamp(), integerRef.getStamp() + 1));

            System.out.println("ref: " + integerRef.getReference());
            System.out.println("stamp: " + integerRef.getStamp());

        }, "A").start();

        new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "\tupdate now");

            System.out.println(integerRef.compareAndSet(1, 2, integerRef.getStamp(), integerRef.getStamp() + 1));
            System.out.println("ref: " + integerRef.getReference());
            System.out.println("stamp: " + integerRef.getStamp());

        }, "B").start();
    }
}
