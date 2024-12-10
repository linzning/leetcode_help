package utils.inout;

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

    /* ----------------------数组--------------------------- */
    /**
     * 所有类型的数组，依次调用toString
     * @param nums
     */
    public static void println(Object[] nums){
        System.out.println(Arrays.toString(nums));
    }

    /* --------------------集合---------------------- */
    /**
     * set 和 list
     * @param nums
     */
    public static void println(Collection<Object> nums){
        System.out.println(nums);
    }

    public static void println(Map<Object,Object>map){
        System.out.println(map);
    }

    /* --------------------类---------------------- */
    public static <T extends BinaryTreeNode> void println(T root){
        BinaryTreeNode.printTree(root);
    }

    public static void println(ListNode head){
        ListNode.printList(head);
    }
}
