package com.demo.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLockTest 读写锁测试
 * @author gnl
 */

public class ReadWriteLockTest {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.put(temp + "", temp);
            }, i + " ").start();
        }

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.get(temp + "");
            }, i + " ").start();
        }
    }
}

class MyCache {

    private volatile Map<String, Object> cache = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        // 进行写操作时，上锁
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " -- 写入数据");

            TimeUnit.MILLISECONDS.sleep(300);
            cache.put(key, value);

            System.out.println(Thread.currentThread().getName() + " -- 写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Object get(String key) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " -- 读取数据");

            TimeUnit.MILLISECONDS.sleep(300);
            Object obj = cache.get(key);

            System.out.println(Thread.currentThread().getName() + " -- 读取完成 ==> " + obj);

            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
        return null;
    }

}
