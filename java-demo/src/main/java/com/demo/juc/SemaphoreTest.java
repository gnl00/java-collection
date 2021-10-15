package com.demo.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * SemaphoreTest 信号量测试
 * @author gnl
 */

public class SemaphoreTest {
    public static void main(String[] args) {
        // 开始有3个资源，若资源量为1，则Semaphore类似synchronized
        int resources = 3;
        // 6个线程抢占3个资源
        int count = 6;

        Semaphore semaphore = new Semaphore(resources);

        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                try {
                    // 占用资源
                    semaphore.acquire();

                    System.out.println(Thread.currentThread().getName() + " 占有资源");

                    // 3s后释放资源
                    TimeUnit.SECONDS.sleep(3);

                    System.out.println(Thread.currentThread().getName() + " 释放资源");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, i + " ").start();
        }
    }
}
