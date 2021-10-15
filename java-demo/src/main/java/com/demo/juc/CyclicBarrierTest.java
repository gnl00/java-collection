package com.demo.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierTest 线程计数加测试
 * @author gnl
 */

public class CyclicBarrierTest {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        int count = 7;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count, () -> {
            System.out.println("=== 集齐七颗龙珠 ===");
        });
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 收集到一颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, i + " ").start();;
        }
    }
}
