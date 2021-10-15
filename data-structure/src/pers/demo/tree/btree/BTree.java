package pers.demo.tree.btree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * BTree 二叉树
 *
 * @author gnl
 */

public class BTree<T> {

    BTNode<T> root;

    public BTree() {
    }

    public BTree(T[] a) {
        this.root = create(a, 0);
    }

    /**
     * 创建完全二叉树
     *
     * @param a
     * @param index
     * @return pers.demo.tree.BTNode<T>
     * @author gnl
     */
    public BTNode<T> create(T[] a, int index) {

        BTNode<T> node = null;

        if (index < a.length) {
            node = new BTNode<>();
            node.data = a[index];

            // 创建左结点
            node.lChild = create(a, index * 2 + 1 );

            // 创建右结点
            node.rChild = create(a, index * 2 + 2 );
        }

        return node;
    }

    /**
     * createMaxHeap 创建大顶堆
     *
     * @return pers.demo.tree.BTNode<T>
     * @author gnl
     */
    public BTNode<T> createMaxHeap(int[] a) {

        return null;
    }

    /**
     * createMinHeap 创建小顶堆
     *
     * @return pers.demo.tree.BTNode<T>
     * @author gnl
     */
    public BTNode<T> createMinHeap() {
        return null;
    }

    private BTNode<T> add(BTNode<T> node) {
        return null;
    }


    /**
     * visit 访问结点
     *
     * @param bt
     * @return void
     * @author gnl
     */
    public static void visit(BTNode bt) {
        if ( null != bt ) {
            System.out.print(bt.data + "\t");
        }
    }

    /**
     * preOrder 先序遍历
     *
     * @return void
     * @author gnl
     */
    public static void preOrder(BTNode btNode) {
        if ( null != btNode ) {
            visit(btNode);
            preOrder(btNode.lChild);
            preOrder(btNode.rChild);
        }
    }

    public static void preOrderNonRecursion(BTNode node) {

        Stack stack = new Stack<>();

        if (node != null) {
            stack.push(node);
        }
        while (stack != null) {
            BTNode topNode = (BTNode) stack.pop();

            visit(topNode);

            stack.push(topNode.rChild);
            stack.push(topNode.lChild);
        }

    }

    /**
     * inOrder 中序遍历
     *
     * @return void
     * @author gnl
     */
    public static void inOrder(BTNode btNode) {
        if ( null != btNode ) {
            inOrder(btNode.lChild);
            visit(btNode);
            inOrder(btNode.rChild);
        }
    }

    /**
     * postOrder 后序遍历
     *
     * @return void
     * @author gnl
     */
    public static void postOrder(BTNode btNode) {
        if ( null != btNode ) {
            postOrder(btNode.lChild);
            postOrder(btNode.rChild);
            visit(btNode);
        }
    }

    /**
     * getTreeSize 获取树的总结点数
     *
     * @param node
     * @return int
     * @author gnl
     */
    public int getTreeSize(BTNode<T> node) {
        int count = 0;
        if (node != null) {

            count++;

            int left = getTreeSize(node.lChild);
            int right = getTreeSize(node.rChild);

            return count + left + right;
        }

        return 0;
    }

    /**
     * getDepth 求树深度
     * 分别求出左右孩子的深度，再+1，即为整棵树的深度
     *
     * @param btNode
     * @return int
     * @author gnl
     */
    public int getDepth(BTNode<T> btNode) {

        int leftDepth, rightDepth;

        if (btNode == null) {
            return 0;
        } else {

            // 求左子树深度
            leftDepth = getDepth(btNode.lChild);

            // 求右子树深度
            rightDepth = getDepth(btNode.rChild);

            return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
        }
    }

    /**
     * search 搜索结点
     *
     * @param node
     * @param key
     * @return pers.demo.tree.BTNode<T>
     * @author gnl
     */
    public BTNode<T> search(BTNode<T> node, int key) {

        while (node != null) {
            if (node.data.equals(key)) {
                return node;
            }
            return search(node.lChild, key) == null ? search(node.rChild, key) : search(node.lChild, key);
        }
        return null;
    }

    /**
     * level 层次遍历 一个结点和它的左右结点先后入队
     *
     * @param node
     * @return void
     * @author gnl
     */
    public void level(BTNode<T> node) {

        LinkedList<BTNode<T>> list = new LinkedList<>();
        BTNode<T> current = null;

        if (node != null) {
            list.add(node);

            while ( !list.isEmpty() ) {

                // 以下两句代码相当于队列操作中的头结点出队
                current = list.getFirst();
                list.removeFirst();

                visit(current);

                if (current.lChild != null) {
                    list.add(current.lChild);
                }

                if (current.rChild != null) {
                    list.add(current.rChild);
                }

            }
        }

    }

    class WidthNode<T> {

        T node;
        int levelNo;

        public WidthNode() {
        }

        public WidthNode(T node, int levelNo) {
            this.node = node;
            this.levelNo = levelNo;
        }

        @Override
        public String toString() {
            return "WidthNode{" +
                    "node=" + node +
                    ", levelNo=" + levelNo +
                    '}';
        }
    }

    /**
     * getWidth 获取二叉树宽
     *
     * @return int
     * @author gnl
     */
    public int getWidth() {

        // 思路：层次遍历时，记录下每一层的宽度，最后再从所有的宽度中选最大值

        return 0;
    }


    /**
     * siftToMax 调整为大顶堆。从下到上，从右到左调整

     * @return void
     * @author gnl
     */
    public void siftToMax(Integer[] a, int low, int high) {
        int i = low, j = i*2;
        int temp = a[i];
        while ( j<= high) {
            if (j<high && a[j] < a[j+1]) {
                ++j;
            }
            if (temp < a[j]) {
                a[i] = a[j];
                i = j;
                j = 2*i;
            } else {
                break;
            }
        }
        a[i] = temp;
    }

    public void heapSort(Integer[] a, int n) {

        int i;
        int temp;
        for (i = n/2; i >= 1 ; --i) {
            siftToMax(a, i, n);
        }
        for (i = n; i >= 2 ; --i) {
            temp = a[1];
            a[1] = a[i];
            a[i] = temp;
            siftToMax(a, 1, i-1);
        }

        for (int j : a) {
            System.out.print(j + "\t");
        }

    }


    /**
     * siftToMin 调整为小顶堆

     * @return void
     * @author gnl
     */
    public void siftToMin() {}

}
