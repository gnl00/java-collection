package com.demo.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LockTest 解决线程安全 方式③ 锁
 *
 * @author gnl
 */

public class LockTest {
    public static void main(String[] args) {
        TicketSales ticketSales = new TicketSales();
        Thread thread1 = new Thread(ticketSales);
        Thread thread2 = new Thread(ticketSales);
        Thread thread3 = new Thread(ticketSales);

        thread1.setName("售票窗口1");
        thread2.setName("售票窗口2");
        thread3.setName("售票窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class TicketSales implements Runnable {

    private int ticket = 100;

    /**
     * 参数 boolean fair 是否为公平锁，默认false
     */
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            // 上锁
            lock.lock();
            try {

                if (ticket > 0) {

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+" 卖票，票号为： "+ticket);
                    ticket--;
                } else {
                    break;
                }

            } finally {
                // 手动解锁
                lock.unlock();
            }

        }
    }
}
