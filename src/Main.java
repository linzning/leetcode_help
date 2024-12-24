import Algorithm.dynamicprogramming.LIS;
import datastructer.Counter;
import datastructer.UnionFind;
import graph.DFS;
import linklist.ListNode;
import tree.BinarySearchNode;
import tree.binarytree.TreeNode;
import utils.MyMath;
import utils.algorithm.BinarySearch;
import utils.algorithm.QuickSort;
import utils.inout.DataUtils;
import utils.inout.Printer;

import java.util.*;

class Solution {
    public int[] duplicateZeros(int[] arr) {
        int n=arr.length;
        int count=0;
        int i=0;
        while (true){
            if(arr[i]==0)count++;
            if(i+count>=n-1)break;
            i++;
        }
        if(count==0)return arr;
        int j=n-1;
        if(arr[i]==0){
            // 刚好够
            if(i+count==n-1){
                arr[j]=arr[j-1]=0;
                j-=2;
            }
            else{
                arr[j]=0;
                j--;
            }
            i--;
        }
        while (i<j){
            if(arr[i]==0){
                arr[j]=arr[j-1]=0;
                j-=2;
            }
            else{
                arr[j]=arr[i];
                j--;
            }
            i--;
        }
        return arr;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        var ans = s.duplicateZeros(arr_int1_1);
        Printer.println((int[]) ans);

    }

    static void init_nums() {
        arr_int1_1 = DataUtils.changeS_nums_1("[1,0,2,3,0,4,5]");
        arr_int1_2 = DataUtils.changeS_nums_1("[2,-6,4,-5,-3,2,-7]");
        arr_int2_1 = DataUtils.changeS_nums_2("[[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]");
        arr_int2_2 = DataUtils.changeS_nums_2("[[2,1],[3,2]]");
    }

    static void init_list() {
        list_int1_1 = DataUtils.changeS_list_1("[1,2]");
        list_int2_1 = DataUtils.changeS_list_2("[[1,2],[4,2],[1,3],[5,2]]");
    }

    static void init_char() {
        arr_char1_1 = DataUtils.changeS_chararr_1("[\"c\", \"f\", \"j\"]");
        arr_char2_1 = DataUtils.changeS_chararr_2("[[\"c\", \"f\", \"j\"],[\"c\", \"f\", \"j\"]]");
    }

    static void init_string() {
        list_string1_1 = DataUtils.changeS_strlist_1("[\"bread\"]");
        list_string2_1 = DataUtils.chanegS_strlist_2("[[\"yeast\",\"flour\"]]");
        arr_string1_1 = DataUtils.changeS_strarr_1("[\"bread\"]");
        arr_string1_2 = DataUtils.changeS_strarr_1("[\"yeast\",\"flour\",\"corn\"]");
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
    static List<List<Integer>> list_int2_1;
    /* arr_int */
    static int[] arr_int1_1;
    static int[] arr_int1_2;
    static int[][] arr_int2_1;
    static int[][] arr_int2_2;
    /* arr_char */
    static char[] arr_char1_1;
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





