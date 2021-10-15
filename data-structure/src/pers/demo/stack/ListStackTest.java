package pers.demo.stack;

/**
 * ListStackTest 链栈
 *
 * @author gnl
 */

public class ListStackTest {
    public static void main(String[] args) {
        ListStack s = new ListStack();

        s.push(9);
        s.push(4);
        s.push(3);
        s.push(6);

        System.out.println(s.peek());
        s.pop();

        System.out.println(s.peek());

    }
}

class ListStack {

    int data;
    ListStack next;

    public ListStack() {}

    public ListStack(int data, ListStack next) {
        this.data = data;
        this.next = next;
    }

    public void push(int e) {
        ListStack pushEl = new ListStack(e, null);

        if (isEmpty()) {
            // 空栈直接插入
            next = pushEl;
        } else {
            // 栈非空，采用头插法
            pushEl.next = next;
            next = pushEl;

        }
    }

    public int pop() {
        if (!isEmpty()) {

            int temp = next.data;
            next = next.next;

            return temp;
        }

        return -1;
    }

    public int peek() {

        if (!isEmpty()) {
            return next.data;
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.next == null;
    }

    @Override
    public String toString() {
        return "ListStack{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
