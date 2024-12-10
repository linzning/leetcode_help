import linklist.ListNode;
import tree.binarytree.BinaryTreeNode;
import tree.binarytree.TreeNode;
import utils.BinarySearch;
import utils.DataUtils;

import java.util.*;

class Solution {
    public int b_search(char[]letters,char target){
        int l=0,r=letters.length-1;
        while (l<=r){
            int mid=l+((r-l)>>1);
            if(letters[mid]<=target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return l>letters.length-1?0:l;
    }
    public char nextGreatestLetter(char[] letters, char target) {
        return letters[b_search(letters,target)];
    }
}

public class Main {
    public static void main(String[] args) {
        init();
        Solution s = new Solution();
        char ans = s.nextGreatestLetter(char1_1,'a');
        System.out.println(ans);

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
        num_int1_1 = DataUtils.changeS_nums_1("[1,1,2,2,3,5,6,6]");
        num_int1_2 = DataUtils.changeS_nums_1("[1,2]");
        num_int2_1 = DataUtils.changeS_nums_2("[[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]]");
        num_int2_2 = DataUtils.changeS_nums_2("[[0,1],[1,0]]");
    }

    static void init_char() {
        char1_1 = DataUtils.changeS_chararr_1("[\"c\", \"f\", \"j\"]");
        char2_1 = DataUtils.changeS_chararr_2("[[\"c\", \"f\", \"j\"],[\"c\", \"f\", \"j\"]]");
    }

    static void init_string() {
        list_string_1=DataUtils.changeS_strlist_1("[\"ce\", \"ffg\", \"ja\"]");
        list_string_2=DataUtils.chanegS_strlist_2("[[\"ce\", \"ffg\", \"ja\"],[\"ce\", \"ffg\", \"ja\"]]");
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
    static List<List<String>>list_string_2;
    static String[] string_arr_1;
    /* 链表 */
    static ListNode head1;
    static ListNode head2;
    static ListNode head3;
    static ListNode[] lists;
    /* tree */
    static TreeNode root;
}





