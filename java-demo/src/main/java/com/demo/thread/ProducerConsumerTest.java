package com.demo.thread;

/**
 * ProducerConsumerTest 生产消费者测试
 *
 * @author gnl
 */

public class ProducerConsumerTest {
    public static void main(String[] args) {
        Operate operate = new Operate();

        Producer producer = new Producer(operate);

        Consumer consumer1 = new Consumer(operate);
        Consumer consumer2 = new Consumer(operate);

        producer.setName("生产者");
        consumer1.setName("消费者1");
        consumer2.setName("消费者2");

        producer.start();
        consumer1.start();
        consumer2.start();
    }
}

class Operate {

    private int product = 0;

    public synchronized void produceProduct() {
        if (product < 20) {

            product++;
            System.out.println(Thread.currentThread().getName() + " 开始生产第 " + product + "个产品");
            notify();

        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() {
        if (product > 0) {
            System.out.println(Thread.currentThread().getName() + " 开始消费第 " + product + "个产品");
            product--;
            notify();

        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Producer extends Thread {

    private Operate operate;

    public Producer(Operate operate) {
        this.operate = operate;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 开始生产产品。。。");
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            operate.produceProduct();
        }
    }
}

class Consumer extends Thread {

    private Operate operate;

    public Consumer(Operate operate) {
        this.operate = operate;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 开始消费产品...");
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            operate.consumeProduct();
        }
    }
}
