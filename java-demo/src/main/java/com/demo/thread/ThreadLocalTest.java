package com.demo.thread;

/**
 * ThreadLocalTest
 *
 * @author gnl
 */

public class ThreadLocalTest {

    private static ThreadLocal<String> localVar = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            localVar.set("localVar in thread AA");
            print();
            System.out.println("aa after print and remove ===> " + localVar.get());
        }, "AA").start();

        new Thread(() -> {
            localVar.set("localVar in thread BB");
            print();
            System.out.println("bb after print and remove ===> " + localVar.get());
        }, "BB").start();
    }

    public static void print() {
        System.out.println(Thread.currentThread().getName() + " ===> " + localVar.get());
        localVar.remove();
    }
}
