package com.demo.thread;

import java.util.concurrent.*;

/**
 * CreateThreadTest4 多线程的创建 方式④
 * 利用Executors 根据需要创建线程池
 *
 * @author gnl
 */

public class CreateThreadTest4 {
    public static void main(String[] args) {

        // ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        ThreadPoolExecutor service = (ThreadPoolExecutor) executorService;

        // 设计线程池属性
        service.setKeepAliveTime(5, TimeUnit.SECONDS);

        System.out.println(service.getClass());

        // 执行指定的线程操作，需要提供实现Runnable或Callable接口的实现类的实例对象
        service.execute(new MyRunnable1());
        service.execute(new MyRunnable2());

        // 适用于Callable
        // service.submit(Callable接口实例);

        // 关闭线程池
        service.shutdown();

    }

}

class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2 != 0){
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        }
    }
}

class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0){
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        }
    }
}
