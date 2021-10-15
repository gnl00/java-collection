package pers.demo.tree.tbtree;

/**
 * TBTreeTest 线索二叉树
 *
 * @author gnl
 */

public class TBTreeTest {

    static void createInThread(TBTNode root) {
        TBTNode pre = null;

        if (root != null) {
            inThread(root, pre);
            pre.rChild = null;
            pre.rTag = 1;
        }
    }

    static void inThread(TBTNode node, TBTNode pre) {

        if (null != node) {

            inThread(node.lChild, pre);
            if (node.lChild == null) {
                node.lChild = pre;
                node.lTag = 1;
            }

            if (pre != null && pre.rChild == null) {
                pre.rChild = node;
                pre.rTag = 1;
            }
            pre = node;
            node = node.rChild;

            inThread(node, pre);

        }

    }

}

class TBTree {

    TBTNode root;

    public TBTree() {}


}

class TBTNode {

    int data;
    int lTag;
    int rTag;
    TBTNode lChild;
    TBTNode rChild;

    public TBTNode() {
    }

    public TBTNode(int data, int lTag, int rTag, TBTNode lChild, TBTNode rChild) {
        this.data = data;
        this.lTag = lTag;
        this.rTag = rTag;
        this.lChild = lChild;
        this.rChild = rChild;
    }
}
