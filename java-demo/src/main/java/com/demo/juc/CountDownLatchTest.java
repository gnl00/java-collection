package com.demo.juc;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatchTest 线程计数减少测试
 * @author gnl
 */

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {

        int threadCount = 6;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 离开");

                // 每离开一个线程，计数减一
                // countDown() 方法会将计数器-1，调用 countDown 方法的线程不会阻塞
                countDownLatch.countDown();

            }, i + " ").start();
        }

        // 线程全部离开，countDownLatch倒数到0，锁门
        // 调用 await()，线程就会阻塞
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " 锁门");

    }
}
