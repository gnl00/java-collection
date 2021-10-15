package pers.demo.queue;

import java.util.Arrays;

/**
 * ArrayQueueTest 循环顺序队
 *
 * @author gnl
 */

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue();

        System.out.println(q.isEmpty());
        System.out.println(q.isFull());

        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);

        System.out.println("peek: " + q.peek());
        System.out.println(q.deQueue());

        System.out.println("peek: " + q.peek());
        System.out.println(q.deQueue());


    }
}

class ArrayQueue {

    int front;
    int rear;
    int[] data;
    private static int maxSize = 10;

    public ArrayQueue() {
        init();
    }

    public void init() {
        front = rear = 0;
        data = new int[maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (front + 1) % maxSize == rear;
    }

    public void enQueue(int el) {

        if (!isFull()) {
            // 队未满，先移动指针，再存入元素
            rear = (rear + 1) % maxSize;
            data[rear] = el;
        }

    }

    public int deQueue() {

        if (!isEmpty()) {
            // 先移动指针，再让元素出队
            front = (front + 1) % maxSize;
            return data[front];

        } else {
            return -1;
        }
    }

    public int peek() {

        if (!isEmpty()) {
            return data[(front + 1) % maxSize];
        }

        return -1;

    }


    @Override
    public String toString() {
        return "ArrayQueue{" +
                "front=" + front +
                ", rear=" + rear +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
