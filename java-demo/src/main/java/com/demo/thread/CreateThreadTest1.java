package com.demo.thread;

/**
 * CreateThreadTest1 多线程的创建 方式①
 * 1. 创建一个继承自Thread 类的子类
 * 2. 在Thread 的子类中重写run() 方法
 * 3. 创建自定义的Thread 子类实例
 * 4. 通过start() 方法启动线程
 *
 * @author gnl
 */

public class CreateThreadTest1 {
    public static void main(String[] args) {
//        MyThread myThread1 = new MyThread();
//        MyThread myThread2 = new MyThread();
//
//        myThread1.start();
//        myThread2.start();

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + " 偶数 ==》 " + i);
                }
            }
        });

        thread.start();

        new Thread(() -> {

            for (int i = 0; i < 100; i++) {
                if (i%2 != 0){
                    System.out.println(Thread.currentThread().getName() +" 奇数 ==》 "+i);
                }
            }
        }).start();


    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0){
                System.out.println(Thread.currentThread().getName() +" "+i);
            }
        }
    }
}
