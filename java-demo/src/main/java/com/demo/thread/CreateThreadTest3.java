package com.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * CreateThreadTest3 多线程的创建 方式③
 * 1. 创建Callable 接口的实现类
 * 2. 重写call() 方法，将需要执行的操作声明在call() 方法中
 * 3. 创建Callable 实现类的实例对象，并作为参数传递到FutureTask 构造函数中，创建FutureTask 实例
 * 3. 将FutureTask 实例作为参数传递到Thread 类的构造器中，创建Thread 对象
 * 4. 调用Thread 对象的start() 方法
 * 5. 可调用FutureTask 实例的get() 方法，获取Callable实现类中call() 方法的返回值
 *
 * @author gnl
 */

public class CreateThreadTest3 {
    public static void main(String[] args) throws Exception {
        MyCallable myCallable = new MyCallable();
        FutureTask<Object> futureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        Object retValue = futureTask.get();
        System.out.println(String.format("return value: %d", retValue));
    }
}

class MyCallable implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
