package pers.demo.tree;

/**
 * BSTreeTest 二叉查找树
 *
 * @author gnl
 */

public class BSTreeTest {
    public static void main(String[] args) {
        int[] a = {9, 4, 3, 11, 2, 6, 10, 15};

        BSTree t = new BSTree();
        t.createBSTree(a);
        System.out.println(t);

        System.out.println(t.search(t.root, 2));
    }
}

class BSTree {

    BTNode root;

    public BSTree() {}

    @Override
    public String toString() {
        return "BSTree{" +
                "root=" + root +
                '}';
    }

    /**
     * 创建二叉查找树
     *
     * @return void
     * @author gnl
     */
    public BTNode createBSTree(int[] a) {

        int index = 0;

        this.root = new BTNode(a[index++], null, null);
        BTNode btNode = null;

        while (index < a.length) {
            btNode = new BTNode(a[index++], null, null);
            insert(this.root, btNode);
        }

        return this.root;

    }

    /**
     * insert 插入结点
     *
     * @param parent
     * @param node
     * @return void
     * @author gnl
     */
    public void insert(BTNode parent, BTNode node) {

        if (parent.data > node.data) {

            if (parent.lChild == null) {
                parent.lChild = node;
            } else {
                insert(parent.lChild, node);
            }

        }else if (parent.data < node.data) {

            if (parent.rChild == null) {
                parent.rChild = node;
            } else {
                insert(parent.rChild, node);
            }

        } else {
            return;
        }

    }

    /**
     * search 查找结点
     *
     * @param node
     * @param key
     * @return pers.demo.tree.bstree.BTNode
     * @author gnl
     */
    public BTNode search(BTNode node, int key) {

        while (node != null) {

            if (node.data == key) {
                return node;
            } else if (node.data > key) {
                return search(node.lChild, key);
            } else {
                return search(node.rChild, key);
            }
        }

        return null;

    }

    /**
     * delNode 删除结点
     *
     * @param node
     * @param key
     * @return int
     * @author gnl
     */
    public int delNode(BTNode node, int key) {

        while (node != null) {
            BTNode pos = search(node, key);
            if (pos == null) {
                return -1;
            } else {


                // ① 需要删除的结点为叶子结点
                getDel(pos);

                // ② 需要删除的结点有一个左孩子或一个右孩子

                // ③ 需要删除的结点有左右孩子


            }
        }
        return -1;
    }

    /**
     * getDel 找到需要删除的结点
     *
     * @param node
     * @return pers.demo.tree.bstree.BTNode
     * @author gnl
     */
    private BTNode getDel(BTNode node) {

        while (node.lChild != null) {
            getDel(node.lChild);
        }

        return null;

    }

    /**
     * doDel 执行删除操作
     *
     * @return void
     * @author gnl
     */
    private void doDel() {}


}

class BTNode {

    int data;
    BTNode lChild;
    BTNode rChild;

    public BTNode() {
    }

    public BTNode(int data, BTNode lChild, BTNode rChild) {
        this.data = data;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    @Override
    public String toString() {
        return "BTNode{" +
                "data=" + data +
                ", lChild=" + lChild +
                ", rChild=" + rChild +
                '}';
    }
}

