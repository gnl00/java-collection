package pers.demo.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * BTreeTest 二叉树
 *
 * @author gnl
 */

public class BTreeTest {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};

        BTree t = new BTree(a);
        System.out.println(t);

        System.out.println("************ preOrder *************");
        t.preOrder(t.root);
        System.out.println();

        t.preOrderNonRecursive(t.root);
        System.out.println();

        System.out.println("*********** inOrder **************");
        t.inOrder(t.root);
        System.out.println();

        t.inOrderNonRecursive(t.root);
        System.out.println();

        System.out.println("************ postOrder **************");
        t.postOrder(t.root);
        System.out.println();

        System.out.println("*********** depth ***************");
        System.out.println(t.getDepth(t.root));

        System.out.println("*********** width ***************");
        int[] b = {1,2,3};
        BTree tree = new BTree(b);
        System.out.println(t.getWidth(tree.root));
    }
}

class BTree {

    BNode root;

    public BTree(int[] a) {
        this.root = create(a, 0);
    }

    /**
     * create 创建完全二叉树
     *
     * @param a
     * @param index
     * @return pers.demo.tree.BNode
     * @author gnl
     */
    public BNode create(int[] a, int index) {
        BNode node = null;
        if (index < a.length) {
            node = new BNode(a[index], null, null);
            node.lChild = create(a, index * 2 + 1);
            node.rChild = create(a, index * 2 + 2);
        }
        return node;
    }

    public void preOrder(BNode node) {
        if (node != null) {
            visit(node);
            preOrder(node.lChild);
            preOrder(node.rChild);

        }
    }

    public void preOrderNonRecursive(BNode node) {
        Stack<BNode> s = new Stack();
        if (node != null) {
            s.push(node);
        }
        while (!s.isEmpty()) {
            BNode top = s.pop();
            visit(top);
            if (top.rChild != null) {
                s.push(top.rChild);
            }
            if (top.lChild != null) {
                s.push(top.lChild);
            }
        }

    }

    public void inOrder(BNode node) {
        if (node != null) {
            inOrder(node.lChild);
            visit(node);
            inOrder(node.rChild);
        }
    }

    public void inOrderNonRecursive(BNode node) {
        Stack<BNode> s = new Stack<>();

        if (node != null) {

            // 循环条件 !s.isEmpty() || node != null
            while ( !s.isEmpty() || node != null) {
                while (node != null) {
                    s.push(node);
                    node = node.lChild;
                }

                if ( !s.isEmpty() ) {
                    BNode top = s.pop();
                    visit(top);
                    node = top.rChild;
                }
            }

        }
    }

    public void postOrder(BNode node) {

        if (node != null) {
            postOrder(node.lChild);
            postOrder(node.rChild);
            visit(node);

        }

    }

    /**
     * 将前序遍历结果逆置得到逆后续排列
     * 观察逆后续排列和后续排列结果得出，逆后续遍历需要将前序遍历中左右孩子的入栈顺序反过来
     *
     * @return void
     * @author gnl
     */
    public void postOrderNonRecursive() {}

    public void visit(BNode node) {
        if (node != null) {
            System.out.print(node.data + "\t");
        }
    }

    public int getDepth(BNode node) {
        if (node == null) {
            return 0;
        } else {
            int left = getDepth(node.lChild);
            int right = getDepth(node.rChild);
            return (left > right ? left : right) + 1;
        }
    }

    public int getWidth(BNode node) {
        Queue<WNode> q = new LinkedList<>();

        // 存储当前结点的层次号
        int lno = 0;

        int max = 0;
        int count = 0;

        WNode head = null;
        if (node != null) {

            q.add(new WNode(1, node));

            // 队列非空
            while (!q.isEmpty()) {

                // 头结点出队
                head = q.remove();
                // visit(head.data);

                // 找出最大层，并保存到max中
                if (lno != head.lno) count = 1;
                if (lno == head.lno) count++;
                max = max > count ? max : count;

                // 存储当前结点的层次号
                lno = head.lno;

                // 左孩子不为空，入队
                if (head.data.lChild != null) {
                    q.add(new WNode(lno + 1, head.data.lChild));
                }

                // 右孩子不为空，入队
                if (head.data.rChild != null) {
                    q.add(new WNode(lno + 1, head.data.rChild));
                }

            }

        }

        return max;
    }

    @Override
    public String toString() {
        return "BTree{" +
                "root=" + root +
                '}';
    }
}

// 用于获取二叉树深度的类
class WNode {

    // 结点所在层次号
    int lno;
    BNode data;

    public WNode() {
    }

    public WNode(int lno, BNode data) {
        this.lno = lno;
        this.data = data;
    }

    @Override
    public String toString() {
        return "WNode{" +
                "lno=" + lno +
                ", data=" + data +
                '}';
    }
}

// 二叉树结点类
class BNode {

    int data;
    BNode lChild;
    BNode rChild;

    public BNode(int data, BNode lChild, BNode rChild) {
        this.data = data;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    @Override
    public String toString() {
        return "BNode{" +
                "data=" + data +
                ", lChild=" + lChild +
                ", rChild=" + rChild +
                '}';
    }
}
