import datastructer.Counter;
import linklist.ListNode;
import math.MOD;
import tree.binarytree.TreeNode;
import utils.inout.DataUtils;
import utils.inout.Printer;

import javax.swing.*;
import java.util.*;

class Solution {
    int []_height;
    public int binaryS_l(List<Integer>list,int num){
        int l=0,r=list.size()-1;
        while (l<=r){
            int mid=l+((r-l)>>1);
            if(_height[list.get(mid)]>=num){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public int binaryS_r(List<Integer>list,int num){
        int l=0,r=list.size()-1;
        while (l<=r){
            int mid=l+((r-l)>>1);
            if(_height[list.get(mid)]>=num){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public int maxArea(int[] height) {
        _height=height;
        int n=height.length;
        //数组模拟栈
        List<Integer>stack=new ArrayList<>();
        int maxArea=0;
        //栈中维护递增下标
        for(int i=0;i<n;i++){
            if(stack.isEmpty()||height[i]>height[stack.get(stack.size()-1)]){
                stack.add(i);
            }
        }
        //找左侧最远更大值
        for(int i=n-1;i>=0;i--){
            int index=stack.get(binaryS_l(stack,height[i]));
            if(height[index]>=height[i]){
                maxArea=Math.max(maxArea,(i-index)*height[i]);
            }
        }
        stack.clear();
        //栈中维护递增下标
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()||height[i]>height[stack.get(stack.size()-1)]){
                stack.add(i);
            }
        }
        //找右侧最远更大值
        for(int i=0;i<n;i++){
            int index=stack.get(binaryS_r(stack,height[i]));
            if(height[index]>=height[i]){
                maxArea=Math.max(maxArea,(index-i)*height[i]);
            }
        }
        return maxArea;
    }
}


public class Main {
    //元音字母
    static HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) {
        Solution s = new Solution();
        var ans = s.maxArea(arr_int1_1);
        Printer.println(ans);

    }

    static void init_nums() {
        arr_int1_1 = DataUtils.changeS_nums_1("[1,8,6,2,5,4,8,3,7]");
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





