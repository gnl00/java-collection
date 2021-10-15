package com.demo.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * CallableTest
 *
 * @author gnl
 */

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        // 利用futureTask获取返回值
        Integer res = futureTask.get();
        System.out.println(res);
    }
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            // 输出偶数和
            if ( (i&1) == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
