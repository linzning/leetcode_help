package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树节点
 * 大部分树的方法也放在这里了
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    /**
     *
     * @param x 当前节点值
     * @param left 左孩子
     * @param right 右孩子
     */
    public TreeNode(int x, TreeNode left, TreeNode right){
        val=x;
        this.left=left;
        this.right=right;
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
     * @param nodes int[]
     */
    public static TreeNode buildTree(int[]nodes){
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

    /**
     * 在终端图形化打印二叉树
     */
    public static void printTree(TreeNode root) {
        if (root == null) System.out.println("EMPTY!");
        // 得到树的深度
        int treeDepth = TreeAttribute.getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i ++) {
            for (int j = 0; j < arrayWidth; j ++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth/ 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line: res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i ++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2: line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }

    /**
     * 打印二叉树的辅助方法
     */
    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) return;
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.val);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) return;
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }
}
