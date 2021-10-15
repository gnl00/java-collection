package com.demo.juc;

import java.util.concurrent.*;

/**
 * ThreadPoolTest
 * @author gnl
 */

public class ThreadPoolTest {
    public static void main(String[] args) {
        single();
    }

    /**
     * 创建固定长度的线程池
     * @return void
     */
    public static void fixed() {
        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            fixedExecutorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " ==> " + temp);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        // 关闭线程池
        fixedExecutorService.shutdown();
    }

    /**
     * 创建可缓存的线程池
     * @return void
     */
    public static void cache() {
        ExecutorService cacheExecutorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            cacheExecutorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " ==> " + temp);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        cacheExecutorService.shutdown();
    }

    /**
     * 创建定时线程池
     * @return void
     */
    public static void schedule() {
        ScheduledExecutorService scheduleExecutorService = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 5; i++) {
            scheduleExecutorService.schedule(() -> {
                System.out.println("delay 3 seconds");
            }, 3, TimeUnit.SECONDS);
        }

        for (int i = 0; i < 5; i++) {
            scheduleExecutorService.scheduleAtFixedRate(() -> {
                System.out.println("delay 1 second, execute every 3 seconds");
            }, 1 ,3, TimeUnit.SECONDS);
        }
    }

    /**
     * 创建单一线程池
     * @return void
     */
    public static void single() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            singleThreadExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " " + temp);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        singleThreadExecutor.shutdown();
    }

    /**
     * 创建线程池的正确方式
     */
    public static void theRightWayToBuildAThreadPool() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
    }
}