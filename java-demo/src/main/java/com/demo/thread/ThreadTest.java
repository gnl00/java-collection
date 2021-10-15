package com.demo.thread;

/**
 * ThreadTest
 *
 * @author gnl
 */

public class ThreadTest {
    public static void main(String[] args) {

        Thread aaa = new Thread(() -> {
            System.out.println("AAAAA");
        }, "AAA");

        Thread bbb = new Thread(() -> {

            try {
                aaa.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("BBBBB");

        }, "BBB");

        bbb.start();
        aaa.start();

    }
}
