package utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Utils {
    /**
     * 二分查找int[],偏左
     * @param arr
     * @param low
     * @param high
     * @param key
     * @return
     */
    public static int binarySearch_int_l(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (key == arr[mid]) {
                return mid;  // 找到了元素，返回索引
            }
            else if (key<=arr[mid]) {
                high = mid - 1;  // 在左半边继续查找
            }
            else {
                low = mid + 1;   // 在右半边继续查找
            }
        }
        return high;
    }

    /**
     * string转二维数组
     * @param s
     * @return
     */
    public static int[][] changeS_nums_2(String s){
        s=s.substring(2,s.length()-2)+" ";
        List<String>nums_list=new LinkedList<>();
        int l=0,r=0;
        int len=s.length();
        while(l<len||r<len){
            while(r<len&&s.charAt(r)!=']'){
                r++;
            }
            nums_list.add(s.substring(l,r));
            l=r+3;
            r=l;
        }
        int n=nums_list.size();
        int[][]ans=new int[n][];
        for(int i=0;i<n;i++){
            String num=nums_list.get(i).trim();
            if(num.equals(""))ans[i]=new int[0];
            else{
                String[]nums=nums_list.get(i).trim().split(",");
                int m=nums.length;
                ans[i]=new int[m];
                for(int j=0;j<m;j++){
                    ans[i][j]=Integer.parseInt(nums[j]);
                }
            }
        }
        return ans;
    }

    /**
     * string转二维列表
     * @param s
     * @return
     */
    public static List<List<Integer>> changeS_list_2(String s){
        s=s.substring(2,s.length()-2)+" ";
        List<String>nums_list=new LinkedList<>();
        int l=0,r=0;
        int len=s.length();
        while(l<len||r<len){
            while(r<len&&s.charAt(r)!=']'){
                r++;
            }
            nums_list.add(s.substring(l,r));
            l=r+3;
            r=l;
        }
        int n=nums_list.size();
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>());
            String num=nums_list.get(i).trim();
            if(num.equals(""))continue;
            else{
                String[]nums=nums_list.get(i).trim().split(",");
                int m=nums.length;
                for (String string : nums) {
                    ans.get(i).add(Integer.parseInt(string));
                }
            }
        }
        return ans;
    }
//    /**
//     * 泛型方法：二分查找
//     *
//     * @param arr 已排序的数组，元素必须实现 Comparable 接口
//     * @param key 要查找的元素
//     * @return 如果找到，返回元素在数组中的索引；如果未找到，返回 -1
//     */
//    public static <T extends Comparable<T>> int binarySearch_r(T[] arr, int low, int high, T key) {
//
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            int cmp = key.compareTo(arr[mid]);
//
//            if (cmp == 0) {
//                return mid;  // 找到了元素，返回索引
//            } else if (cmp < 0) {
//                high = mid - 1;  // 在左半边继续查找
//            } else {
//                low = mid + 1;   // 在右半边继续查找
//            }
//        }
//        return low;
//    }

    public static void main(String[] args) {
        int[] num_int1_1 = new int[]{1,2,3};
        int[] num_int1_2 = new int[]{3,0,-6};
        int[][] num_int2_1 = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
        int[][] num_int2_2 = new int[][]{{0, 3}, {3, 6}, {2, 6}, {0, 6}};
        System.out.println(binarySearch_int_l(num_int1_1,0,num_int1_1.length,-1));
    }
}
