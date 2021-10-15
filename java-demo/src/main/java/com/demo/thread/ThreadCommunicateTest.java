package com.demo.thread;

/**
 * ThreadCommunicateTest 线程通信测试 线程1和线程2交叉打印
 *
 * @author gnl
 */

public class ThreadCommunicateTest {
    public static void main(String[] args) {

        CommunicateRunnable runnable = new CommunicateRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.setName("thread1");
        thread2.setName("thread2");

        thread1.start();
        thread2.start();

        String name = thread1.getState().name();
        System.out.println(name);
    }
}

class CommunicateRunnable implements Runnable {

    private int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {

                // 执行notify()，就会唤醒被wait的一个线程
                // 如果有多个线程被wait，就唤醒优先级较高的线程
                notify();

                if (num <= 100) {
                    System.out.println(Thread.currentThread().getName()+" : "+num);
                    num++;

                    try {
                        // 调用wait()方法后线程进入阻塞状态（BLOCKED）
                        // wait()方法后释放锁资源
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }
}
