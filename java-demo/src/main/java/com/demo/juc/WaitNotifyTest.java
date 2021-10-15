package com.demo.juc;

/**
 * WaitNotifyTest 使用notify()和wait()让线程交替打印
 * @author gnl
 */

public class WaitNotifyTest {
    public static void main(String[] args) {

        MyCounter myCounter = new MyCounter();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myCounter.increment();
            }
        }, "AAA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myCounter.decrement();
            }
        }, "BBB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myCounter.increment();
            }
        }, "CCC").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myCounter.decrement();
            }
        }, "DDD").start();

    }
}

class MyCounter {

    /**
     * num从0开始，两个线程分别对num++和num--，交替打印
     */
    private int num = 0;

    public void increment() {
        synchronized (this) {
            while ( num != 0 ) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num++;
            System.out.println(Thread.currentThread().getName() + " ==> " + num);
            notifyAll();
        }

    }

    public void decrement() {
        synchronized (this) {
            while ( num == 0 ) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num--;
            System.out.println(Thread.currentThread().getName() + " ==> " + num);
            notifyAll();
        }
    }
}

