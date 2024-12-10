package tree.binarytree;

import utils.inout.DataUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树父类
 * 里面有创建和打印方法
 */
public class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(){
        val=-1;
        left=right=null;
    }

    public BinaryTreeNode(int val){
        this.val=val;
        left=right=null;
    }

    public BinaryTreeNode(int val,BinaryTreeNode left,BinaryTreeNode right)  {
        this.val=val;
        this.left=left;
        this.right=right;
    }

    public static int getTreeDepth(BinaryTreeNode root) {
        if(root==null)return 0;
        return 1+ Math.max(getTreeDepth(root.left), getTreeDepth(root.right));
    }

    /**
     * 根据leetcode给出的树的列表形式（层序遍历，不存在的节点null）构造一个二叉树
     * 注意,如果节点值为Integer.MIN_VALUE会创建失败
     * @param str
     */
    public static TreeNode buildTree(String str){
        str.replaceAll("null",String.valueOf(Integer.MIN_VALUE));
        int[]nodes= DataUtils.changeS_nums_1(str);
        if(nodes==null||nodes.length==0)return null;
        TreeNode root = new TreeNode(nodes[0]);
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;

        while (!queue.isEmpty() && index < nodes.length) {
            BinaryTreeNode current = queue.poll();
            int leftValue = nodes[index++];
            if (leftValue != Integer.MIN_VALUE) {
                current.left = new TreeNode(leftValue);
                queue.offer(current.left);
            }
            if (index < nodes.length) {
                int rightValue = nodes[index++];
                if (rightValue != Integer.MIN_VALUE) {
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
    public static void printTree(BinaryTreeNode root) {
        if (root == null) System.out.println("EMPTY!");
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

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
    private static void writeArray(BinaryTreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
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
