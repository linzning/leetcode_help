package tree.binarytree;

import java.util.*;

public class TreeTravel {
    /**
     * 前序_递归
     * @param root
     * @return
     */
    public static List<Integer> preorderRecur(TreeNode root){
        List<Integer>ans=new ArrayList<>();
        preorderRecurHelp(root,ans);
        return ans;
    }
    private static void preorderRecurHelp(TreeNode root, List<Integer>ans){
        if(root==null)return;
        ans.add(root.val);
        preorderRecurHelp(root.left,ans);
        preorderRecurHelp(root.right,ans);
    }
    /**
     * 前序_迭代
     * @param root
     * @return
     */
    public static List<Integer> preorder(TreeNode root){
        List<Integer>ans=new ArrayList<>();
        Deque<TreeNode>stack=new ArrayDeque<>();
        if(root==null)return ans;
        stack.offerLast(root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.pollLast();
            ans.add(cur.val);
            //因为是栈所以先把右节点加入
            if(cur.right!=null)stack.offerLast(cur.right);
            if(cur.left!=null)stack.offerLast(cur.left);
        }
        return ans;
    }
    /**
     * 中序_递归
     * @param root
     * @return
     */
    public static List<Integer> inorderRecur(TreeNode root){
        List<Integer>ans=new ArrayList<>();
        inorderRecurHelp(root,ans);
        return ans;
    }
    private static void inorderRecurHelp(TreeNode root, List<Integer>ans){
        if(root==null)return;
        inorderRecurHelp(root.left,ans);
        ans.add(root.val);
        inorderRecurHelp(root.right,ans);
    }
    /**
     * 中序_迭代
     * @param root
     * @return
     */
    public static List<Integer> inorder(TreeNode root){
        List<Integer>ans=new ArrayList<>();
        Deque<TreeNode>stack=new ArrayDeque<>();
        if(root==null)return ans;
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.offerLast(cur);
                cur=cur.left;
            }
            else{
                cur=stack.pollLast();
                ans.add(cur.val);
                cur=cur.right;
            }
        }
        return ans;
    }
    /**
     * 后序_递归
     * @param root
     * @return
     */
    public static List<Integer> postorderRecur(TreeNode root){
        List<Integer>ans=new ArrayList<>();
        postorderRecurHelp(root,ans);
        return ans;
    }
    private static void postorderRecurHelp(TreeNode root, List<Integer>ans){
        if(root==null)return;
        postorderRecurHelp(root.left,ans);
        postorderRecurHelp(root.right,ans);
        ans.add(root.val);
    }
    /**
     * 后序_迭代
     * @param root
     * @return
     */
    public static List<Integer> postorder(TreeNode root){
        List<Integer>ans=new ArrayList<>();
        Deque<TreeNode>stack=new ArrayDeque<>();
        if(root==null)return ans;
        TreeNode cur=root,pre=null;
        while(cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.offerLast(cur);
                cur=cur.left;
            }
            cur=stack.pollLast();
            if(cur.right==null||cur.right==pre){
                ans.add(cur.val);
                pre=cur;
                cur=null;
            }
            else{
                stack.offerLast(cur);
                cur=cur.right;
            }
        }
        return ans;
    }
    /**
     * 统一迭代,只需更改进栈的顺序，然后在中节点后加入null
     * @param root
     * @return
     */
    public static List<Integer> travel(TreeNode root){
        List<Integer>ans=new ArrayList<>();
        Deque<TreeNode>stack=new LinkedList<>();
        if(root==null)return ans;
        stack.offerLast(root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.pollLast();
            if(cur!=null){
                //就是在中节点后加入标志null,只有栈中出null说明遍历到我们要的节点了
                stack.offerLast(cur);
                stack.offerLast(null);
                if(cur.right!=null)stack.offerLast(cur.right);
                if(cur.left!=null)stack.offerLast(cur.left);
            }
            else{
                ans.add(stack.pollLast().val);
            }
        }
        return ans;
    }
    /**
     * 层序_bfs
     * @param root
     * @return
     */
    public static List<Integer> levelorder(TreeNode root){
        Queue<TreeNode>queue=new LinkedList<>();
        List<Integer>ans=new ArrayList<>();
        if(root==null)return ans;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            ans.add(cur.val);
            if(cur.left!=null)queue.offer(cur.left);
            if(cur.right!=null)queue.offer(cur.right);
        }
        return ans;
    }

    /**
     * 把二叉树按层序序列化成字符串，对于null,变成字符n
     * @param root
     * @return
     */
    public static String getLevelSerialTree(TreeNode root){
        Queue<TreeNode>queue=new LinkedList<>();
        StringBuilder ans=new StringBuilder();
        if(root==null)return ans.append('n').append(' ').toString();
        queue.offer(root);
        boolean hasNode=true;
        while(!queue.isEmpty()&&hasNode){
            hasNode=false;
            int size= queue.size();
            while (size>0){
                TreeNode cur=queue.poll();
                if(cur.val==-1)ans.append('n');
                else ans.append(cur.val);
                ans.append(' ');
                if(cur.left==null)queue.offer(new TreeNode(-1,null,null));
                else {
                    queue.offer(cur.left);
                    hasNode=true;
                }
                if(cur.right==null)queue.offer(new TreeNode(-1,null,null));
                else {
                    queue.offer(cur.right);
                    hasNode=true;
                }
                size--;
            }
        }
        return ans.toString();
    }


    /**
     * 把二叉树按层序序列化成字符串，对于null,变成字符n,最多深入一层null
     * @param root
     * @return
     */
    public static String getPreorderSerialTree(TreeNode root){
        StringBuilder ans=new StringBuilder();
        preorderSerialHelp(root,ans);
        return ans.toString();
    }
    private static void preorderSerialHelp(TreeNode root, StringBuilder ans){
        if(root==null){
            ans.append('n').append(' ');
            return;
        }
        ans.append(root.val).append(' ');
        preorderSerialHelp(root.left,ans);
        preorderSerialHelp(root.right,ans);
    }
}
