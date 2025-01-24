import linklist.ListNode;
import tree.binarytree.TreeNode;
import utils.inout.DataUtils;
import utils.inout.Printer;

import java.util.*;
import java.util.stream.IntStream;


class Solution {
    static int MOD=(int)1e9+7;
    long add(long a,long b){
        return (a+b)%MOD;
    }
    long sub(long a,long b){
        return (a-b+MOD)%MOD;
    }

    /**、
     * 把任意整数 a 取模到 [0,MOD-1] 中，无论 a 是正是负
     * @param a
     * @return
     */
    long normal(long a){
        return (a%MOD+MOD)%MOD;
    }

    /**
     * 乘法
     * @param a
     * @param b
     * @return
     */
    long multi(long a,long b){
        return a*b%MOD;
    }

    /**
     * 多个数乘法，每次都要取MOD
     * @param nums
     * @return
     */
    long multi_arr(List<Long>nums){
        long ans=1;
        for(long n:nums){
            ans=ans*n%MOD;
        }
        return ans;
    }

    /**
     * 除（MOD 是质数且 b 不是 MOD 的倍数）
     * @param a
     * @param b
     * @return
     */
    long div(long a,long b){
        return  a * qpow(b, MOD - 2, MOD) % MOD;
    }

    /**
     * 快速幂计算 (x^y) % mod
     * @param x
     * @param y
     * @param mod
     * @return
     */
    private long qpow(long x,int y,int mod){
        long result = 1;
        while (y > 0) {
            if (y % 2 == 1) {
                result = result * x % mod;
            }
            x = x * x % mod;
            y /= 2;
        }
        return result;
    }
    public int numWays(String _s) {
        int n=_s.length();
        char[]s=_s.toCharArray();
        int total_count=0;
        for(char c:s)total_count+=c-'0';
        if(total_count%3!=0)return 0;
        if(total_count==0){
            return (int) (((long)(n-1)*(n-2)/2)%MOD);
        }
        int i=0;
        int numCount=0;
        while (numCount<total_count/3){
            numCount+=s[i++]-'0';
        }
        int pre=i;
        while (s[i]!='1')i++;
        int number1=i-pre+1;
        while (numCount<2*(total_count/3)){
            numCount+=s[i++]-'0';
        }
        pre=i;
        while (s[i]!='1')i++;
        int number2=i-pre+1;
        return (int) multi(number1,number2);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        var ans = s.numWays("00000000");
        Printer.println(ans);


        long num=1;
        for(int i=1;i<1000;i++){
            num*=i;
            System.out.println(i+": "+num);
        }
    }

    static void init_nums() {
        arr_int1_1 = DataUtils.changeS_nums_1("[-1,0,0,1,1,1]");
        arr_int1_2 = DataUtils.changeS_nums_1("[0,0,1,0,0,0]");
        arr_int2_1 = DataUtils.changeS_nums_2("[[0,1],[0,2],[0,3]]");
        arr_int2_2 = DataUtils.changeS_nums_2("[[0,2],[2,3]]");
    }

    static void init_list() {
        list_int1_1 = DataUtils.changeS_list_1("[1,2,3]");
        list_int1_2 = DataUtils.changeS_list_1("[1,2]");
        list_int2_1 = DataUtils.changeS_list_2("[[0,0,1],[0,2,2],[1,3,2]]");
        list_int2_2 = DataUtils.changeS_list_2("[[1,2],[4,2],[1,3],[5,2]]");

        list_boolean1_1 = DataUtils.changeS_list_boolean_1("[false,false,true,false,true,true,false]");
    }

    static void init_char() {
        arr_char1_1 = DataUtils.changeS_chararr_1("[\"a\",\"b\",\"c\",\"c\",\"e\",\"d\"]");
        arr_char1_2 = DataUtils.changeS_chararr_1("[\"b\",\"c\",\"b\",\"e\",\"b\",\"e\"]");
        arr_char2_1 = DataUtils.changeS_chararr_2("[[\"c\", \"f\", \"j\"],[\"c\", \"f\", \"j\"]]");
    }

    static void init_string() {
        arr_string1_1 = DataUtils.changeS_strarr_1("[\"011001\",\"000000\",\"010100\",\"001000\"]");
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





