package tree.binarytree;

import utils.DataUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode的二叉树节点
 */
public class TreeNode extends BinaryTreeNode {

    TreeNode(int x) {
        super(x);
    }

    /**
     *
     * @param x 当前节点值
     * @param left 左孩子
     * @param right 右孩子
     */
    public TreeNode(int x, TreeNode left, TreeNode right){
        super(x,left,right);
    }

    /**
     * 单个节点的toString方法
     * @return string
     */
    @Override
    public String toString() {
        return "this.val=" + val;
    }
}
