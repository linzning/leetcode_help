import datastructer.Counter;
import linklist.ListNode;
import tree.BinarySearchNode;
import tree.binarytree.TreeNode;
import utils.algorithm.BinarySearch;
import utils.inout.DataUtils;
import utils.inout.Printer;

import java.util.*;

class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {

    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        long ans = s.minLengthAfterRemovals(list_int1_1);
        Printer.println(ans);

    }

    static {
        init();
    }

    static void init() {
        init_list();
        init_nums();
        init_char();
        init_string();
        init_listNode();
        init_tree();
    }

    static void init_list() {
        list_int1_1 = DataUtils.changeS_list_1("[1,2]");
        list_int2_1 = DataUtils.changeS_list_2("[[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]");
    }

    static void init_nums() {
        num_int1_1 = DataUtils.changeS_nums_1("[0,1,7,4,4,5]");
        num_int1_2 = DataUtils.changeS_nums_1("[1,2,3,4,5]");
        num_int2_1 = DataUtils.changeS_nums_2("[[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]]");
        num_int2_2 = DataUtils.changeS_nums_2("[[0,1],[1,0]]");
    }

    static void init_char() {
        char1_1 = DataUtils.changeS_chararr_1("[\"c\", \"f\", \"j\"]");
        char2_1 = DataUtils.changeS_chararr_2("[[\"c\", \"f\", \"j\"],[\"c\", \"f\", \"j\"]]");
    }

    static void init_string() {
        list_string_1 = DataUtils.changeS_strlist_1("[\"ce\", \"ffg\", \"ja\"]");
        list_string_2 = DataUtils.chanegS_strlist_2("[[\"ce\", \"ffg\", \"ja\"],[\"ce\", \"ffg\", \"ja\"]]");
        string_arr_1 = DataUtils.changeS_strarr_1("[\"ce\", \"ffg\", \"ja\"]");
    }

    static void init_listNode() {
        head1 = ListNode.buildList("[1, 2, -3, 3, 1]");
        head2 = ListNode.buildList("[1, 2, -3, 3, 1]");
        head3 = ListNode.buildList("[1, 2, -3, 3, 1]");
        lists = new ListNode[]{head1, head2, head3};
    }

    static void init_tree() {
        root = TreeNode.buildTree("[1, 2, -3, 3, 1]");
        //BinaryTreeNode.printTree(root);
    }

    /* list */
    static List<Integer> list_int1_1;
    static List<List<Integer>> list_int2_1;
    /* nums */
    static int[] num_int1_1;
    static int[] num_int1_2;
    static int[][] num_int2_1;
    static int[][] num_int2_2;
    /* char */
    static char[] char1_1;
    static char[][] char2_1;
    /* string */
    static List<String> list_string_1;
    static List<List<String>> list_string_2;
    static String[] string_arr_1;
    /* 链表 */
    static ListNode head1;
    static ListNode head2;
    static ListNode head3;
    static ListNode[] lists;
    /* tree */
    static TreeNode root;
}





