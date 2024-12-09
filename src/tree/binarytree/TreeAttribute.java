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
    public static int getTreeDepth(BinaryTreeNode root) {
        if(root==null)return 0;
        return 1+ Math.max(getTreeDepth(root.left), getTreeDepth(root.right));
    }

    /**
     * 树的最小高度
     * @param root
     * @return int 树的最小高度，根节点到最近叶子节点的最短路径上的节点数量。
     */
    public static int getTreeMinDepth(BinaryTreeNode root){
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

    /**
     * 获取树的直径
     * @param root
     * @return
     */
    public static int getTreediameter(BinaryTreeNode root){
        return dfs(root)[0];
    }
    //int[]{根为root的直径,以root为根的最大深度}
    private static int[]dfs(BinaryTreeNode root){
        if(root==null)return new int[]{0,0};
        int[]a=dfs(root.left);
        int[]b=dfs(root.right);
        int depth=Math.max(a[1],b[1])+1;
        return new int[]{Math.max(a[1]+b[1],Math.max(a[0],b[0])),depth};
    }
}
