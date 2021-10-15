package com.demo.juc;

import java.util.concurrent.*;

/**
 * ForkJoinTaskTest 分支合并框架测试
 * @author gnl
 */

public class ForkJoinTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 计算从0加到100
        MyTask myTask = new MyTask(0, 100);

        // ForkJoinTask需要通过ForkJoinPool来执行
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(myTask);

        System.out.println(forkJoinTask.get());

        forkJoinPool.shutdown();

    }
}

/**
 * RecursiveTask<T> 有返回值的递归，返回值类型为T
 * RecursiveAction 无返回的递归
 * @author gnl
 */
class MyTask extends RecursiveTask<Integer> {

    /**
     * 拆分的界限
     */
    private static final int ADJUST_VALUE = 10;

    private int begin;
    private int end;
    private int res;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if ((end - begin) <= ADJUST_VALUE) {
            for (int i = begin; i < end; i++) {
                res += i;
            }
        } else {
            int mid = (begin + end) / 2;
            // 使用二分法拆分任务
            MyTask myTask1 = new MyTask(begin, mid);
            MyTask myTask2 = new MyTask(mid, end);

            // fork方法用于将新创建的子任务放入当前线程的work queue队列中
            myTask1.fork();
            myTask2.fork();

            // join方法用于让当前线程阻塞，直到对应的子任务完成运行并返回执行结果
            res = myTask1.join() + myTask2.join();
        }
        return res;
    }
}
