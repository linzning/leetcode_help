package tree;

import tree.binarytree.BinaryTreeNode;

public class BinarySearchNode extends BinaryTreeNode {
    int val;
    BinarySearchNode left;
    BinarySearchNode right;
    int size;   // 当前节点为根的子树大小
    int count;  // 当前节点的重复数量
    BinarySearchNode(int val){
        super(val);
    }
    BinarySearchNode(int val, BinarySearchNode left, BinarySearchNode right){
        super(val,left,right);
    }

    public static int getMin(BinarySearchNode root) {
        if (root == null) {
            return -1;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    public static int getMax(BinarySearchNode root) {
        if (root == null) {
            return -1;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

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

    public BinarySearchNode insert(BinarySearchNode root, int value) {
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

    // 此处返回值为删除 value 后的新 root
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

    // 此处以右子树的最小值为例
    BinarySearchNode findMinNode(BinarySearchNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    int queryRank(BinarySearchNode root, int v) {
        if (root == null) return 0;
        if (root.val == v) return (root.left!=null ? root.left.size : 0) + 1;
        if (root.val > v) return queryRank(root.left, v);
        return queryRank(root.right, v) + (root.left!=null ? root.left.size : 0) +
                root.count;
    }

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
}
