package tree;

import tree.binarytree.BinaryTreeNode;

/**
 * 二叉搜索树
 * 纯屎，不如用TreeSet,TreeMap
 */
public class BinarySearchNode {
    int val;
    BinarySearchNode left;
    BinarySearchNode right;
    int size;   // 当前节点为根的子树大小,包括当前节点
    int count;  // 当前节点的重复数量,没有重复是0
    public BinarySearchNode(int val){
        this.val=val;
    }
    public BinarySearchNode(int val, BinarySearchNode left, BinarySearchNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }

    /**
     * 求最小值
     * @param root
     * @return
     */
    public static int getMin(BinarySearchNode root) {
        if (root == null) {
            return -1;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    /**
     * 求最大值
     * @param root
     * @return
     */
    public static int getMax(BinarySearchNode root) {
        if (root == null) {
            return -1;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    /**
     * 是否存在target
     * @param root
     * @param target
     * @return
     */
    public static boolean search(BinarySearchNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        } else if (target < root.val) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }

    /**
     * 插入值
     * @param root
     * @param value
     * @return
     */
    public static BinarySearchNode insert(BinarySearchNode root, int value) {
        if (root == null) {
            return new BinarySearchNode(value);
        }
        if (value < root.val) {
            root.left = insert(root.left, value);
        } else if (value > root.val) {
            root.right = insert(root.right, value);
        } else {
            root.count++;  // 节点值相等，增加重复数量
        }
        root.size = root.count + (root.left!=null? root.left.size : 0) +
                (root.right!=null ? root.right.size : 0);  // 更新节点的子树大小
        return root;
    }

    /**
     * 删除一个特定值
     * @param root
     * @param value
     * @return 删除 value 后的新 root
     */
    BinarySearchNode remove(BinarySearchNode root, int value) {
        if (root == null) {
            return root;
        }
        if (value < root.val) {
            root.left = remove(root.left, value);
        } else if (value > root.val) {
            root.right = remove(root.right, value);
        } else {
            if (root.count > 1) {
                root.count--;  // 节点重复数量大于1，减少重复数量
            } else {
                if (root.left == null) {
                    BinarySearchNode temp = root.right;
                    return temp;
                } else if (root.right == null) {
                    BinarySearchNode temp = root.left;
                    return temp;
                } else {
                    BinarySearchNode successor = findMinNode(root.right);
                    root.val = successor.val;
                    root.count = successor.count;  // 更新重复数量
                    // 当 successor.count > 1时，也应该删除该节点，否则
                    // 后续的删除只会减少重复数量
                    successor.count = 1;
                    root.right = remove(root.right, successor.val);
                }
            }
        }
        // 继续维护size，不写成 --root.size;
        // 是因为value可能不在树中，从而可能未发生删除
        root.size = root.count + (root.left!=null ? root.left.size : 0) +
                (root.right!=null ? root.right.size : 0);
        return root;
    }

    /**
     * 找最小节点
     * @param root
     * @return
     */
    BinarySearchNode findMinNode(BinarySearchNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    /**
     * 找最大节点
     * @param root
     * @return
     */
    BinarySearchNode findMaxNode(BinarySearchNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    /**
     * 查找排名为v的元素
     * @param root
     * @param v
     * @return
     */
    int queryRank(BinarySearchNode root, int v) {
        if (root == null) return 0;
        if (root.val == v) return (root.left!=null ? root.left.size : 0) + 1;
        if (root.val > v) return queryRank(root.left, v);
        return queryRank(root.right, v) + (root.left!=null ? root.left.size : 0) +
                root.count;
    }

    /**
     * 查找第k大元素
     * @param root
     * @param k
     * @return
     */
    int querykth(BinarySearchNode root, int k) {
        if (root == null) return -1;  // 或者根据需求返回其他合适的值
        if (root.left!=null) {
            if (root.left.size >= k) return querykth(root.left, k);
            if (root.left.size + root.count >= k) return root.val;
        } else {
            if (k == 1) return root.val;
        }
        return querykth(root.right,
                k - (root.left!=null ? root.left.size : 0) - root.count);
    }

    /* ---------------------区间查询元素个数----------------------- */

    /**
     * 查询>key的元素个数
     * @param root
     * @param target
     * @return
     */
     public static int countGreater(BinarySearchNode root,int target){
        if (root == null) {
            return 0;
        }
        if (root.val == target) {
            return root.right==null?0:root.right.size;
        } else if (target < root.val) {
            return root.count+1+countGreater(root.left,target)+(root.right==null?0:root.right.size);
        } else {
            return countGreater(root.right,target);
        }
    }

    /**
     * 查询>=key的元素个数
     * @param root
     * @param target
     * @return
     */
    public static int countGreaterEqual(BinarySearchNode root,int target){
        if (root == null) {
            return 0;
        }
        if (root.val == target) {
            return root.count+1+(root.right==null?0:root.right.size);
        } else if (target < root.val) {
            return root.count+1+countGreaterEqual(root.left,target)+(root.right==null?0:root.right.size);
        } else {
            return countGreaterEqual(root.right,target);
        }
    }

    /**
     * 查询<key的元素个数
     * @param root
     * @param target
     * @return
     */
    public static int countLower(BinarySearchNode root,int target){
        if (root == null) {
            return 0;
        }
        if (root.val == target) {
            return root.left==null?0:root.left.size;
        } else if (target > root.val) {
            return root.count+1+countLower(root.right,target)+(root.left==null?0:root.left.size);
        } else {
            return countLower(root.left,target);
        }
    }

    /**
     * 查询<=key的元素个数
     * @param root
     * @param target
     * @return
     */
    public static int countLowerEqual(BinarySearchNode root,int target){
        if (root == null) {
            return 0;
        }
        if (root.val == target) {
            return root.count+1+(root.left==null?0:root.left.size);
        } else if (target > root.val) {
            return root.count+1+countLowerEqual(root.right,target)+(root.left==null?0:root.left.size);
        } else {
            return countLowerEqual(root.left,target);
        }
    }

    /**
     * 求[low,high]内的元素个数
     * @param root
     * @param low
     * @param high
     * @return
     */
    public static int countInRange(BinarySearchNode root, int low,int high){
        if (root == null) {
            return 0;
        }

        // 如果当前节点的值小于区间的下界，递归右子树
        if (root.val < low) {
            return countInRange(root.right, low, high);
        }

        // 如果当前节点的值大于区间的上界，递归左子树
        if (root.val > high) {
            return countInRange(root.left, low, high);
        }

        // 当前节点的值在区间内，返回当前节点的重复数量 + 左右子树的计数
        int count = root.count+1; // 当前节点的重复数量
        count += countInRange(root.left, low, high);  // 递归左子树
        count += countInRange(root.right, low, high); // 递归右子树

        return count;
    }
}
