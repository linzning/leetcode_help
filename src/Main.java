import datastructer.Counter;
import datastructer.UnionFind;
import graph.DFS;
import linklist.ListNode;
import tree.BinarySearchNode;
import tree.binarytree.TreeNode;
import utils.MyMath;
import utils.algorithm.BinarySearch;
import utils.inout.DataUtils;
import utils.inout.Printer;

import java.util.*;

class Solution {
    class UnionFind{
        int MAXN;
        int[]parents;
        UnionFind(int n){
            MAXN=n;
            parents=new int[n];
            for(int i=0;i<n;i++){
                parents[i]=i;
            }
        }
        int find(int x){
            if (parents[x] == x)return x;
            return parents[x] = find(parents[x]);
        }
        void merge(int i,int j){
            int pi=find(i),pj=find(j);
            if(pi!=pj)parents[pi]=pj;
        }
        void erase(int x){
            parents[x]=x;
        }
        @Override
        public String toString(){
            HashMap<Integer, List<Integer>>map=new HashMap<>();//集合号->节点列表
            for(int i=0;i<MAXN;i++){
                int setNum=find(i);
                List<Integer>nodeList=map.getOrDefault(setNum,new ArrayList<>());
                nodeList.add(i);
                map.put(setNum,nodeList);
            }
            return map.toString();
        }
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // 建图
        HashMap<Integer,List<int[]>>time_meet=new HashMap<>();//time->多个会议双方
        TreeSet<Integer>timeList=new TreeSet<>();//时间序列
        for(int[]m:meetings){
            List<int[]>meets=time_meet.getOrDefault(m[2],new ArrayList<>());
            meets.add(new int[]{m[0],m[1]});
            time_meet.put(m[2],meets);
            timeList.add(m[2]);
        }
        UnionFind uf=new UnionFind(n);
        uf.merge(firstPerson,0);
        for(int time:timeList){
            List<int[]>meets=time_meet.get(time);
            for(int[]meet:meets){
                uf.merge(meet[0],meet[1]);
            }
            for(int[]meet:meets){
                if(uf.find(meet[0])!= uf.find(0)){
                    uf.erase(meet[0]);
                    uf.erase(meet[1]);
                }
            }
        }
        List<Integer>ans=new LinkedList<>();
        ans.add(0);
        for(int i=1;i<n;i++){
            if(uf.find(i)==uf.find(0)){
                ans.add(i);
            }
        }
        return ans;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        var ans = s.findAllPeople(6,num_int2_1,1);
        Printer.println(ans);

    }
    static void init_nums() {
        num_int1_1 = DataUtils.changeS_nums_1("[3,7]");
        num_int1_2 = DataUtils.changeS_nums_1("[3,1,2,4]");
        num_int2_1 = DataUtils.changeS_nums_2("[[1,2,5],[2,3,8],[1,5,10]]");
        num_int2_2 = DataUtils.changeS_nums_2("[[0,1],[1,0]]");
    }

    static void init_list() {
        list_int1_1 = DataUtils.changeS_list_1("[1,2]");
        list_int2_1 = DataUtils.changeS_list_2("[[1,2],[4,2],[1,3],[5,2]]");
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





