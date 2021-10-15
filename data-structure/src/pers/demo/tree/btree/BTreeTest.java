package pers.demo.tree.btree;


import java.util.Stack;

/**
 * BTreeTest 二叉树
 *
 * @author gnl
 */

public class BTreeTest {
    public static void main(String[] args) {
        Integer[] a = {9, 4, 3, 11, 2, 6, 10, 15};

        BTree<Integer> bt = new BTree<>(a);

        preOrder(bt.root);
        System.out.println();

        preOrderNonRecursion(bt.root);
        System.out.println();

        inOrder(bt.root);
        System.out.println();

        inOrderNonRecursion(bt.root);
        System.out.println();

        postOrder(bt.root);
        System.out.println();

        postOrderNonRecursion(bt.root);
        System.out.println();

//
//        System.out.println(bt.getDepth(bt.root));
//
//        System.out.println(bt.search(bt.root, 11));
//
//        bt.level(bt.root);
//        System.out.println();
//
//        System.out.println(bt.getTreeSize(bt.root));
//
//        // System.out.println(bt.getWidth());
//
//        Integer[] b = {0, 9, 4, 3, 11, 2, 6, 10, 15};
//
//        bt.heapSort(b, a.length);

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

    /**
     * preOrderNonRecursion 前序遍历非递归实现
     *
     * @param node
     * @return void
     * @author gnl
     */
    public static void preOrderNonRecursion(BTNode node) {
        Stack stack = new Stack<>();

        if (node != null) {
            stack.push(node);
        }
        while (stack.size() > 0) {
            BTNode topNode = (BTNode) stack.pop();

            visit(topNode);

            if (topNode.rChild != null) {
                stack.push(topNode.rChild);
            }

            if (topNode.lChild != null) {
                stack.push(topNode.lChild);
            }
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
     * inOrderNonRecursion 中序遍历非递归实现
     *
     * @param node
     * @return void
     * @author gnl
     */
    public static void inOrderNonRecursion(BTNode node) {
        Stack stack = new Stack<>();

        if (node != null) {

            // 遍历条件 stack.size() > 0 || node != null
            while (stack.size() > 0 || node != null) {

                while (node != null) {
                    stack.push(node);
                    node = node.lChild;
                }

                if (stack.size() > 0) {
                    BTNode top = (BTNode) stack.pop();
                    visit(top);
                    node = top.rChild;
                }

            }
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
     * postOrderNonRecursion 后序遍历非递归实现
     *
     * @param node
     * @return void
     * @author gnl
     */
    public static void postOrderNonRecursion(BTNode node) {

        BTNode temp = null;

        if ( node != null ) {

            Stack<BTNode> s1 = new Stack<>();
            Stack<BTNode> s2 = new Stack<>();

            s1.push(node);

            while (s1.size() > 0) {
                    temp = s1.pop();
                    s2.push(temp);

                    if (temp.lChild != null) {
                        s1.push(temp.lChild);
                    }
                if (temp.rChild != null) {
                    s1.push(temp.rChild);
                }
            }
            while (s2.size() > 0) {
                temp = s2.pop();
                visit(temp);
            }


        }

    }

    public static void visit(BTNode bt) {
        if ( null != bt ) {
            System.out.print(bt.data + "\t");
        }
    }

    /**
     * createBTreeManually 手动创建一棵二叉树
     *
     * @return pers.demo.tree.BTNode
     * @author gnl
     */
    public static BTree<Integer> createBTreeManually() {

        BTNode<Integer> root = new BTNode<>();
        BTNode<Integer> node2 = new BTNode<>();
        BTNode<Integer> node3 = new BTNode<>();
        BTNode<Integer> node4 = new BTNode<>();
        BTNode<Integer> node5 = new BTNode<>();

        root.data = 1;
        root.lChild = node2;
        root.rChild = node3;

        node2.data = 2;
        node2.lChild = node4;
        node2.rChild = node5;

        node3.data = 3;

        node4.data = 4;
        node5.data = 5;

        BTree<Integer> bTree = new BTree<>();
        bTree.root = root;

        return bTree;

    }
}
