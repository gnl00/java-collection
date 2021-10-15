package com.demo.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLockTest ReentrantLock和Condition测试
 * Condition方法的调用必须在lock和unlock之间
 * @author gnl
 */

public class ReentrantLockTest {
    public static void main(String[] args) {
        MyReentrantLock myReentrantLock = new MyReentrantLock();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myReentrantLock.increment();
            }
        }, "AAA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myReentrantLock.decrement();
            }
        }, "BBB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myReentrantLock.decrement();
            }
        }, "CCC").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myReentrantLock.increment();
            }
        }, "DDD").start();
    }
}

class MyReentrantLock {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     * num从0开始，多个线程分别对num++和num--，交替打印
     */
    private int num = 0;

    public void increment() {

        lock.lock();
        try {

            while ( num !=0 ) {
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + " ==> " + num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {

        lock.lock();
        try {

            while ( num ==0 ) {
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + " ==> " + num);
            condition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
