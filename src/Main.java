import linklist.ListNode;
import linklist.SkipList;
import tree.binarytree.BinaryTreeNode;
import tree.binarytree.TreeNode;
import utils.BinarySearch;
import utils.Utils;

import java.util.*;

class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles,(a,b)->a[0]-b[0]);
        int[]presum=new int[tiles.length+1];
        int[]right=new int[tiles.length];
        for(int i=0;i<tiles.length;i++){
            presum[i+1]=presum[i]+tiles[i][1]-tiles[i][0]+1;
            right[i]=tiles[i][1];
        }
        int ans=0;
        for(int i=0;i<tiles.length;i++){
            int rightlen=tiles[i][0]+carpetLen-1;
            int index= BinarySearch.binarySearch_int_l(right,0,right.length-1,rightlen);
            int len=presum[index+1]-presum[i];
            if(index!=tiles.length-1){
                len+=rightlen-tiles[index+1][0]<0?0:rightlen-tiles[index+1][0]+1;
            }
            ans=Math.max(ans,len);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        init();
        Solution s = new Solution();
        int ans = s.maximumWhiteTiles(num_int2_1,10);
        System.out.println(ans);
    }
    static void init(){
        init_list();
        init_nums();
        init_char();
        init_string();
        init_listNode();
        init_tree();
    }
    static void init_list(){
        list_int1_1 = Utils.changeS_list_1("[1,2]");
        list_int2_1 = Utils.changeS_list_2("[[1],[2],[3],[]]");
    }
    static void init_nums(){
        num_int1_1 = Utils.changeS_nums_1("[1,2,3]");
        num_int1_2 = Utils.changeS_nums_1("[1,2]");
        num_int2_1 = Utils.changeS_nums_2("[[1,5],[10,11],[12,18],[20,25],[30,32]]");
        num_int2_2 = Utils.changeS_nums_2("[[0,1],[1,0]]");
    }
    static void init_char(){
        char1_1=new char[]{'a','b'};
        char2_1 = new char[][]{{'(', ')'}};
    }
    static void init_string(){
        {
            list_string = new ArrayList<>();
            list_string.add("E12");
            list_string.add("1X1");
            list_string.add("21S");
        }
        words = new String[]{"7"};
    }
    static void init_listNode(){
        head1 = ListNode.buildList("[1, 2, -3, 3, 1]");
        head2 = ListNode.buildList("[1, 2, -3, 3, 1]");
        head3 = ListNode.buildList("[1, 2, -3, 3, 1]");
        lists = new ListNode[]{head1, head2, head3};
    }
    static void init_tree(){
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





