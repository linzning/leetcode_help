import list.ListNode;
import list.SkipList;
import tree.binarytree.TreeAttribute;
import tree.binarytree.TreeNode;
import tree.binarytree.TreeTravel;
import utils.Utils;

import java.util.*;

class Solution {

}
public class Main {
    public static void main(String[] args) {
        List<Integer> list_int1_1 = new ArrayList<>(Arrays.asList(2, 1, 3, 2, 1));
        List<List<Integer>> list_int2_1;
        list_int2_1 = Utils.changeS_list_2("[[1],[2],[3],[]]");
        int[] num_int1_1 = new int[]{3, 5};
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
        int[] nodes = {4,-7,-3,-1,-1,-9,-3,9,-7,-4,-1,6,-1,-6,-6,-1,-1,0,6,5,-1,9,-1,-1,-1,-4,-1,-1,-1,-2};
        TreeNode root = TreeNode.buildTree(nodes);

        Solution s = new Solution();
        int ans = s.
        System.out.println(ans);
    }
}





