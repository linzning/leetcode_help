import datastructer.SegmentTree;
import datastructer.SegmentTreeNode;
import linklist.ListNode;
import linklist.SkipList;
import tree.binarytree.BinaryTreeNode;
import tree.binarytree.TreeNode;
import utils.BinarySearch;
import utils.Utils;
import utils.data.Counter;

import java.awt.geom.Area;
import java.security.PrivilegedExceptionAction;
import java.sql.DriverAction;
import java.util.*;

class Solution {
    public long countGood(int[] nums, int k) {
        Counter<Integer>count=new Counter<>();
        return 0L;
    }
}

public class Main {
    public static void main(String[] args) {
        init();
//        Solution s = new Solution();
//        long ans = s.countGood(num_int1_1, 2);
//        System.out.println(ans);

        Counter<Integer>count=new Counter<>(num_int1_1);
        System.out.println(count);
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
        list_int1_1 = Utils.changeS_list_1("[1,2]");
        list_int2_1 = Utils.changeS_list_2("[[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]");
    }

    static void init_nums() {
        num_int1_1 = Utils.changeS_nums_1("[1,2,3,1,5,3,6]");
        num_int1_2 = Utils.changeS_nums_1("[1,2]");
        num_int2_1 = Utils.changeS_nums_2("[[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]]");
        num_int2_2 = Utils.changeS_nums_2("[[0,1],[1,0]]");
    }

    static void init_char() {
        char1_1 = new char[]{'a', 'b'};
        char2_1 = new char[][]{{'(', ')'}};
    }

    static void init_string() {
        {
            list_string = new ArrayList<>();
            list_string.add("E12");
            list_string.add("1X1");
            list_string.add("21S");
        }
        words = new String[]{"7"};
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
    static List<String> list_string;
    static String[] words;
    /* 链表 */
    static ListNode head1;
    static ListNode head2;
    static ListNode head3;
    static ListNode[] lists;
    /* tree */
    static TreeNode root;
}





