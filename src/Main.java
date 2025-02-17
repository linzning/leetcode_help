import linklist.ListNode;
import tree.binarytree.TreeNode;
import utils.inout.DataUtils;
import utils.inout.Printer;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;


class Solution {
    public int findSpecialInteger(int[] arr) {
        int m=arr.length/4;
        for (int i : new int[]{m, m * 2 + 1}) {
            int x = arr[i];
            // > x 等价于 >= x+1
            if (lowerBound(arr, x + 1) - lowerBound(arr, x) > m) {
                return x;
            }
        }
        // 如果答案不是 arr[m] 也不是 arr[2m+1]，那么答案一定是 arr[3m+2]
        return arr[m * 3 + 2];
    }
    int lowerBound(int[]arr,int x){
        int left=0,right=arr.length-1;
        while (left<=right){
            int mid=left+((right-left)>>1);
            if(arr[mid]>=x){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        var ans = s.findSpecialInteger("abaacbaecebce", "ba*c*ce");
        Printer.println(ans);

    }

    static void init_nums() {
        arr_int1_1 = DataUtils.changeS_nums_1("[5,6,2]");
        arr_int1_2 = DataUtils.changeS_nums_1("[-1,-2,-3]");
        arr_int2_1 = DataUtils.changeS_nums_2("[[0,0,2],[1,1,1]]");
        arr_int2_2 = DataUtils.changeS_nums_2("[[0,2],[2,3]]");
    }

    static void init_list() {
        list_int1_1 = DataUtils.changeS_list_1("[1,2,3]");
        list_int1_2 = DataUtils.changeS_list_1("[1,2]");
        list_int2_1 = DataUtils.changeS_list_2("[[0,1,1],[0,1,1],[0,0,1]]");
        list_int2_2 = DataUtils.changeS_list_2("[[1,2],[4,2],[1,3],[5,2]]");

        list_boolean1_1 = DataUtils.changeS_list_boolean_1("[false,false,true,false,true,true,false]");
    }

    static void init_char() {
        arr_char1_1 = DataUtils.changeS_chararr_1("[\"a\",\"b\",\"c\",\"c\",\"e\",\"d\"]");
        arr_char1_2 = DataUtils.changeS_chararr_1("[\"b\",\"c\",\"b\",\"e\",\"b\",\"e\"]");
        arr_char2_1 = DataUtils.changeS_chararr_2("[[\"+\",\"+\",\"+\"],[\".\",\".\",\".\"],[\"+\",\"+\",\"+\"]]");
    }

    static void init_string() {
        arr_string1_1 = DataUtils.changeS_strarr_1("[\"catg\",\"ctaagt\",\"gcta\",\"ttca\",\"atgcatc\"]");
        arr_string1_2 = DataUtils.changeS_strarr_1("[\"cde\",\"thh\",\"ghh\"]");
        list_string1_1 = DataUtils.changeS_strlist_1("[\"dog\",\"s\",\"gs\"]");
        list_string2_1 = DataUtils.chanegS_strlist_2("[[\"yeast\",\"flour\"]]");
    }

    static void init_listNode() {
        head1 = ListNode.buildList("[2,1,5]");
        head2 = ListNode.buildList("[1, 2, -3, 3, 1]");
        head3 = ListNode.buildList("[1, 2, -3, 3, 1]");
        lists = new ListNode[]{head1, head2, head3};
    }

    static void init_tree() {
        root = TreeNode.buildTree("[1,5,3,null,4,10,6,9,2]");
        //TreeNode.printTree(root);
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
    /* list_boolean */
    static List<Boolean> list_boolean1_1;
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





