import datastructer.trietree.TrieMap;
import linklist.ListNode;
import tree.binarytree.TreeNode;
import utils.inout.DataUtils;
import utils.inout.Printer;

import java.util.*;


class Solution {
    public int countDistinct(int[] nums, int k, int p) {

    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        var ans = s.sumPrefixScores(arr_string1_1);
        Printer.println((int[]) ans);

    }

    static void init_nums() {
        arr_int1_1 = DataUtils.changeS_nums_1("[2,5,5,1,2,20]");
        arr_int1_2 = DataUtils.changeS_nums_1("[2,-6,4,-5,-3,2,-7]");
        arr_int2_1 = DataUtils.changeS_nums_2("[[0,1],[1,2]]]");
        arr_int2_2 = DataUtils.changeS_nums_2("[[2,1],[3,2]]");
    }

    static void init_list() {
        list_int1_1 = DataUtils.changeS_list_1("[1,2]");
        list_int1_2 = DataUtils.changeS_list_1("[1,2]");
        list_int2_1 = DataUtils.changeS_list_2("[[1,2],[4,2],[1,3],[5,2]]");
        list_int2_2 = DataUtils.changeS_list_2("[[1,2],[4,2],[1,3],[5,2]]");
    }

    static void init_char() {
        arr_char1_1 = DataUtils.changeS_chararr_1("[\"a\",\"b\",\"c\",\"c\",\"e\",\"d\"]");
        arr_char1_2 = DataUtils.changeS_chararr_1("[\"b\",\"c\",\"b\",\"e\",\"b\",\"e\"]");
        arr_char2_1 = DataUtils.changeS_chararr_2("[[\"c\", \"f\", \"j\"],[\"c\", \"f\", \"j\"]]");
    }

    static void init_string() {
        arr_string1_1 = DataUtils.changeS_strarr_1("[\"abc\",\"ab\",\"bc\",\"b\"]");
        arr_string1_2 = DataUtils.changeS_strarr_1("[\"cde\",\"thh\",\"ghh\"]");
        list_string1_1 = DataUtils.changeS_strlist_1("[\"apple\",\"apple\",\"app\"]");
        list_string2_1 = DataUtils.chanegS_strlist_2("[[\"yeast\",\"flour\"]]");
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

    /* list_int */
    static List<Integer> list_int1_1;
    static List<Integer> list_int1_2;
    static List<List<Integer>> list_int2_1;
    static List<List<Integer>> list_int2_2;
    /* arr_int */
    static int[] arr_int1_1;
    static int[] arr_int1_2;
    static int[][] arr_int2_1;
    static int[][] arr_int2_2;
    /* arr_char */
    static char[] arr_char1_1;
    static char[] arr_char1_2;
    static char[][] arr_char2_1;
    /* string */
    static List<String> list_string1_1;
    static List<List<String>> list_string2_1;
    static String[] arr_string1_1;
    static String[] arr_string1_2;
    /* 链表 */
    static ListNode head1;
    static ListNode head2;
    static ListNode head3;
    static ListNode[] lists;
    /* tree */
    static TreeNode root;

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
}





