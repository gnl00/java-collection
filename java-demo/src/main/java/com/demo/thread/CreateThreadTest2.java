package com.demo.thread;

/**
 * CreateThreadTest2 多线程的创建 方式②
 * 1. 创建一个实现Runnable 接口的实现类
 * 2. 实现类中重写run() 方法
 * 3. 创建实现类的实例对象
 * 4. 将实例对象作为参数传递到Thread 类的构造器中，创建Thread 实例
 * 5. 调用Thread 实例对象的start() 方法
 *
 * @author gnl
 */

public class CreateThreadTest2 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0){
                System.out.println(Thread.currentThread().getName() +" "+i);
            }
        }
    }
}
