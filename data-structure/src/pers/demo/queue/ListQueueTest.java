package pers.demo.queue;

/**
 * ListQueueTest 循环链队
 *
 * @author gnl
 */

public class ListQueueTest {
    public static void main(String[] args) {
        ListQueue queue = new ListQueue();

        System.out.println(queue.isEmpty());

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);

        System.out.println(queue);

        QNode el = queue.deQueue();
        System.out.println(el);

        System.out.println(queue.peek());
    }
}

class ListQueue {

    QNode front;
    QNode rear;

    public ListQueue() {
        init();
    }

    public ListQueue(QNode front, QNode rear) {
        this.front = front;
        this.rear = rear;
    }

    public void init() {
        this.front = this.rear = null;
    }

    public void enQueue(int el) {
        QNode n = new QNode(el, null);

        if (isEmpty()) {
            this.front = this.rear = n;
        } else {
            this.rear.next = this.rear = n;
        }
    }

    public QNode deQueue() {

        if ( !isEmpty() ) {
            QNode tmp = this.front;
            this.front = this.front.next;

            return tmp;
        }
        return null;
    }

    public QNode peek() {

        if (!isEmpty()) {

            return this.front;

        }
        return null;
    }

    public boolean isEmpty() {
        return front == null || rear == null;
    }

    @Override
    public String toString() {
        return "ListQueue{" +
                "front=" + front +
                ", rear=" + rear +
                '}';
    }
}

class QNode {

    int data;
    QNode next;

    public QNode() {
    }

    public QNode(int data, QNode next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "QNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
