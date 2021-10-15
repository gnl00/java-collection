package pers.demo.stack;

import java.util.Arrays;

/**
 * ArrayStackTest 顺序栈
 *
 * @author gnl
 */

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack s = new ArrayStack();

        s.push(9);
        s.push(4);
        s.push(2);
        s.push(11);

        System.out.println(s.peek());

        s.pop();

        System.out.println(s.peek());

        s.push(3);

        s.showEl();

    }
}

class ArrayStack {

    int top;
    int[] data;
    static final int MAXSIZE = 10;

    public ArrayStack() {
        init();
    }

    public ArrayStack(int top, int[] data) {
        this.top = top;
        this.data = data;
    }

    private void init() {
        top = -1;
        data = new int[MAXSIZE];
    }

    public void push(int e) {

        if (top == data.length) {
            System.out.println("stack is full");
        } else {
            data[++top] = e;
        }

    }

    public int pop() {
        if (!isEmpty()) {
            return data[top--];
        }
        return -1;
    }

    public int peek() {
        if (!isEmpty()) {
            return data[top];
        }
        return -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void showEl() {

        for (int i : data) {
            System.out.print(i + "\t");
        }

    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "top=" + top +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
