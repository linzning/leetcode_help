package tree.binarytree;

/**
 * 一些树的属性
 */
public class TreeAttribute {
    /**
     * getTreeDepth(node)
     * @param root
     * @return
     */
    public static int getTreeDepth(TreeNode root) {
        if(root==null)return 0;
        return 1+ Math.max(getTreeDepth(root.left), getTreeDepth(root.right));
    }

    /**
     * 树的最小高度
     * @param root
     * @return int 树的最小高度，根节点到最近叶子节点的最短路径上的节点数量。
     */
    public static int getTreeMinDepth(TreeNode root){
        if (root==null)return 0;
        if(root.left==null)return getTreeMinDepth(root.right)+1;
        if(root.right==null)return getTreeMinDepth(root.left)+1;
        return Math.min(getTreeMinDepth(root.left),getTreeMinDepth(root.right))+1;
    }

    /**
     * 求树的重心，
     * @param root
     * @return
     * TODO: 2024/9/19 树的重心还没写
     */
    public static int getTreeCentroid(TreeNode root){
        return -1;
    }


    private static int diaMeter;
    /**
     * 获取树的直径(不一定经过root)
     * @param root
     * @return
     */
    public static int getTreediameter(TreeNode root){
        diaMeter=0;
        diameter_dfs(root);
        return diaMeter;
    }
    private static int diameter_dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int lLen = diameter_dfs(node.left) + 1; // 左子树最大链长+1
        int rLen = diameter_dfs(node.right) + 1; // 右子树最大链长+1
        diaMeter = Math.max(diaMeter, lLen + rLen); // 两条链拼成路径
        return Math.max(lLen, rLen); // 当前子树最大链长
    }
}
