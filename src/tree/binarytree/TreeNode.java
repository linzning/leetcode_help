package tree.binarytree;

import utils.Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树节点
 * 大部分树的方法也放在这里了
 */
public class TreeNode extends BinaryTreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

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

    /**
     * 根据leetcode给出的树的列表形式（层序遍历，不存在的节点是-1(leetcode给的是null)）构造一个二叉树
     * @param str
     */
    public static TreeNode buildTree(String str){
        int[]nodes= Utils.changeS_nums_1(str);
        if(nodes==null||nodes.length==0)return null;
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;

        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode current = queue.poll();
            int leftValue = nodes[index++];
            if (leftValue != -1) {
                current.left = new TreeNode(leftValue);
                queue.offer(current.left);
            }
            if (index < nodes.length) {
                int rightValue = nodes[index++];
                if (rightValue != -1) {
                    current.right = new TreeNode(rightValue);
                    queue.offer(current.right);
                }
            }
        }
        return root;
    }
}
