package com.demo.collection.list;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ArrayListTest
 * @author gnl
 */

public class ArrayListTest {
    public static void main(String[] args) {

        /**
         * ArrayList线程不安全的表现
         * 报异常 java.util.ConcurrentModificationException
         * 原因 多线程并发争抢同一个资源，并且没有加锁
         * 解决办法
         * 1. Vector 不推荐
         * 2. new CopyOnWriteArrayList<>();
         *    写时复制
         *    CopyOnWrite容器即写时复制容器
         *    往写时复制容器添加元素的时候，不直接往当前容器Object[]添加，而是对当前容器使用Arrays.copy()复制出一个新的容器               Object[] newElement，然后向新容器里添加元素
         *    添加完元素之后，再使用setArray()方法将原容器的引用指向新容器
         *    这样做的好处是可以对CopyOnWrite容器进行并发的读，而不需要加锁
         *    因为原容器不会添加任何元素，所以CopyOnWrite容器也是一种读写分离思想，读原容器，写新容器
         * 3. List<String> list = Collections.synchronizedList(new ArrayList<>());
         */

        List<String> list = new CopyOnWriteArrayList<>();
        int n = 10;
        for (int i = 0; i < n; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            }, i + " ").start();
        }
    }
}
