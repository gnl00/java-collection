package com.demo.juc;

import java.util.concurrent.TimeUnit;

/**
 * VolatileTest volatile 关键字测试
 * @author gnl
 */

public class VolatileTest {

    public static volatile int num = 0;

    public static void main(String[] args) {
        // visibilityTest();
        atomicityTest();
    }

    /**
     * visibilityTest volatile 保证可见性
     * @return void
     * @author gnl
     */
    public static void visibilityTest() {
        new Thread(() -> {

            while (0 == num) {
                System.out.println("do something...");
            }

        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 使用main线程修改num的值，因使用volatile修饰，主线程将num值改为1这一操作能被线程A可见，线程A就会停止
        num = 1;
        System.out.println(num);
    }

    /**
     * atomicityTest volatile不保证原子性
     * @return void
     */
    public static void atomicityTest() {

        /**
         * 20个线程，每个线程执行1000次add方法，正确的执行结果20*1000
         */
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    synchronizedAdd();
                }
            }).start();
        }

        // 当前线程执行完毕后，获取当前处于活跃状态的线程数，释放当前CPU的执行权，确保所有的线程都执行过一遍
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t" + num);
    }

    public static void add() {
        num++;
    }

    /**
     * synchronized 保证原子性
     * @author gnl
     */
    public synchronized static void synchronizedAdd() {
        num++;
    }

}
