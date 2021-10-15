package pers.demo.tree.btree;

/**
 * BTNode 二叉树结点
 *
 * @author gnl
 */

public class BTNode<T> {

    T data;
    BTNode<T> lChild;
    BTNode<T> rChild;

    public BTNode() {}

    /**
     * childCount 统计结点中含有多少个孩子结点
     *
     * @param node
     * @return int
     * @author gnl
     */
    public int childCount(BTNode<T> node) {

        if (node.lChild != null && node.rChild != null) {
            return 2;
        } else if (node.lChild != null || node.rChild != null) {
            return 1;
        }

        return 0;
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
