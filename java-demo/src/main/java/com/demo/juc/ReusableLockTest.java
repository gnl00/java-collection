package com.demo.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReusableLockTest 可重用锁测试
 *
 * @author gnl
 */

public class ReusableLockTest {
    public static void main(String[] args) {
        Phone1 phone1 = new Phone1();
        Phone2 phone2 = new Phone2();

//        new Thread(() -> {
//            phone1.sms();
//        }, "A").start();
//
//        new Thread(() -> {
//            phone1.sms();
//        }, "B").start();

        new Thread(() -> {
            phone2.sms();
        },"A").start();

        new Thread(() -> {
            phone2.sms();
        },"B").start();

    }
}

class Phone1 {

    public synchronized void sms() {
        System.out.println(Thread.currentThread().getName() + "Phone1 ==> sms");
        call();
    }

    public synchronized void call() {
        System.out.println(Thread.currentThread().getName() + "Phone1 ==> call");
    }

}

class Phone2 {

    Lock lock = new ReentrantLock();

    public void sms() {

        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "Phone2 ==> sms");

            // call方法中也有锁，拿到了sms方法的锁也即拿到了call方法的锁
            call();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void call() {

        // lock和unlock必须配对出现，否则会造成死锁
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "Phone2 ==> call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }

}
