package com.demo.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFutureTest 异步回调测试
 *
 * @author gnl
 */

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t没有返回值的异步回调");
        }).get();

        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t有返回值的异步回调");
            // 报错，不再执行后续操作
            // int i = 10/0;
            return 100;
        });
        supplyAsync.get();

        CompletableFuture<Integer> integerCompletableFuture = supplyAsync.whenComplete((res, err) -> {
            System.out.println("正常返回res: " + res);
            System.out.println("异常返回err: " + err);

            int i = 10/0;

        }).exceptionally(e -> {
            System.out.println("出错啦: " + e.getMessage());
            return 404;
        });

        System.out.println("获取到返回值: " + integerCompletableFuture.get());
    }
}
