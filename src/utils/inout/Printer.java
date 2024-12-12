package utils.inout;

import datastructer.Counter;
import linklist.ListNode;
import tree.binarytree.BinaryTreeNode;

import java.util.*;

public class Printer {
    /**
     * 单值byte short int long float double
     * @param a
     * @param <T>
     */
    public static <T extends Number> void println(T a){
        System.out.println(a);
    }

    public static void println(Character c){
        System.out.println(c);
    }

    public static void println(Boolean b){
        System.out.println(b);
    }

    public static void println(String s){
        System.out.println(s);
    }

    /* --------------------------------数组-------------------------------- */
    public static void println(int[] nums){
        System.out.println(Arrays.toString(nums));
    }

    public static void println(char[] nums){
        System.out.println(Arrays.toString(nums));
    }

    public static void println(double[] nums){
        System.out.println(Arrays.toString(nums));
    }

    public static void println(int[][] nums){
        for(int[]n:nums){
            System.out.println(Arrays.toString(n));
        }
    }

    /**
     * 所有类型的数组，依次调用toString
     * @param nums
     */
    public static void println(Object[] nums){
        System.out.println(Arrays.toString(nums));
    }

    /* --------------------------------集合--------------------------------- */
    public static <T> void println(List<T> nums){
        System.out.println(nums);
    }

    public static <T>  void println(Set<T> nums){
        System.out.println(nums);
    }

    public static <T,V>  void println(Map<T,V>map){
        System.out.println(map);
    }

    /* ---------------------------------类---------------------------------- */
    public static <T extends BinaryTreeNode> void println(T root){
        BinaryTreeNode.printTree(root);
    }

    public static void println(ListNode head){
        ListNode.printList(head);
    }
    public static <T> void println(Counter<T>count){
        System.out.println(count);
    }
}
