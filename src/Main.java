import linklist.ListNode;
import linklist.SkipList;
import tree.binarytree.BinaryTreeNode;
import tree.binarytree.TreeNode;
import utils.Utils;

import java.util.*;

class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int left=0;
        int ans=0;
        for(int i=0;i<nums.size();i++){
            int x=nums.get(i);
            map.put(x,map.getOrDefault(x,0)+1);
            while (map.size()>k+1){
                int n=nums.get(left++);
                map.put(n,map.get(n)-1);
                if(map.get(n)==0)map.remove(n);
            }
            ans=Math.max(ans,map.values().stream().max(Integer::compareTo).orElse(-1));
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Integer> list_int1_1 = new ArrayList<>(Arrays.asList(3,4,2,1));
        List<List<Integer>> list_int2_1;
        list_int2_1 = Utils.changeS_list_2("[[1],[2],[3],[]]");
        int[] num_int1_1 = new int[]{1,3,2,3,1,3};
        int[] num_int1_2 = new int[]{};
        int[][] num_int2_1;
        num_int2_1 = Utils.changeS_nums_2("[[1,0],[1,2],[1,3]]");
        int[][] num_int2_2;
        num_int2_2 = Utils.changeS_nums_2("[[0,1],[1,0]]");
        char[][] char2_1 = new char[][]{{'(', ')'}};
        List<String> list_string = new ArrayList<>();
        list_string.add("E12");
        list_string.add("1X1");
        list_string.add("21S");
        String[] words = new String[]{"7"};
        //创建链表
        int[] linknode1 = {1, 2, -3, 3, 1};
        ListNode head1 = ListNode.buildList(linknode1);
        int[] linknode2 = {1, 3, 4};
        ListNode head2 = ListNode.buildList(linknode2);
        int[] linknode3 = {2, 6};
        ListNode head3 = ListNode.buildList(linknode3);
        ListNode[] lists = new ListNode[]{head1, head2, head3};
        // 创建完全二叉树的节点
        int[] nodes = {4, -7, -3, -1, -1, -9, -3, 9, -7, -4, -1, 6, -1, -6, -6, -1, -1, 0, 6, 5, -1, 9, -1, -1, -1, -4, -1, -1, -1, -2};
        TreeNode root = TreeNode.buildTree(nodes);
        //BinaryTreeNode.printTree(root);

        Solution s = new Solution();
        int ans = s.longestEqualSubarray(list_int1_1,0);
        System.out.println(ans);
    }
}





