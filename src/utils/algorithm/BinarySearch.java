package utils.algorithm;

import java.util.Arrays;

public class BinarySearch {
    /**
     * 对int[]整体进行二分查找
     * @param arr
     * @param key
     * @return
     */
    public static int binarySearch(int[]arr,int key) {
        return binarySearch_intarr(arr, 0, arr.length-1,key);
    }

    /**
     * java自带的二分查找，可以有int char long,这是演示用函数
     * @param nums
     * @param key
     * @return 找到返回下标 ，否则返回-(插入点+1)
     */
    private static int _BinarySearch(int[]nums,int key){
        return Arrays.binarySearch(nums,key);
        // 如果<0 要求插入点就是~ans 也就是-ans-1;
    }

    /**
     * 二分查找，找到就返回
     * @param arr
     * @param l 包括
     * @param r 包括
     * @param key
     * @return 找到返回下标，找不到返回-(插入点+1)
     */
    public static int binarySearch_intarr(int[]arr,int l,int r,int key){
        while (l<=r){
            int mid=l+((r-l)>>1);
            if(arr[mid]==key){
                return mid;
            }else if(arr[mid]<key){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return -(l+1);
    }

    /**
     * 二分查找int[],左边界
     * @param arr
     * @param l 包括在内
     * @param h 包括在内
     * @param key
     * @return 找不到返回-(插入点+1)，否则返回最左侧相等的
     */
    public static int lowerBound_intarr(int[] arr, int l, int h, int key) {
        int low=l,high=h;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (key<=arr[mid]) {
                high = mid - 1;  // 在左半边继续查找
            }
            else {
                low = mid + 1;   // 在右半边继续查找
            }
        }
        if(low>h||arr[low]!=key)return -(low+1);
        return low;
    }
    /**
     * 二分查找int[],右边界
     * @param arr
     * @param l 包括在内
     * @param h 包括在内
     * @param key
     * @return 找不到返回-(插入点+1)，否则返回最右侧相等的
     */
    public static int higherBound_intarr(int[] arr, int l, int h, int key) {
        int low=l,high=h;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (key<arr[mid]) {
                high = mid - 1;  // 在左半边继续查找
            }
            else {
                low = mid + 1;   // 在右半边继续查找
            }
        }
        if(high<l||arr[high]!=key)return -(low+1);
        return high;
    }

    /**
     * 严格小于的第一个元素
     * @param arr
     * @param l 包括
     * @param h 包括
     * @param key
     * @return 找不到返回-1，否则下标
     */
    public static int binarySearch_intarr_l(int[] arr, int l, int h, int key) {
        int low=l,high=h;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (key<=arr[mid]) {
                high = mid - 1;  // 在左半边继续查找
            }
            else {
                low = mid + 1;   // 在右半边继续查找
            }
        }
        return high;
    }

    /**
     * 严格大于的第一个元素
     * @param arr
     * @param l 包括
     * @param h 包括
     * @param key
     * @return 找不到返回-1，否则下标
     */
    public static int binarySearch_intarr_r(int[] arr, int l, int h, int key) {
        int low=l,high=h;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (key<arr[mid]) {
                high = mid - 1;  // 在左半边继续查找
            }
            else {
                low = mid + 1;   // 在右半边继续查找
            }
        }
        return low>h?-1:low;
    }

    /**
     * 查询区间[low,high]内元素个数
     * @param arr
     * @param l 原数组下标，包含
     * @param h
     * @param low 区间最小值，包含
     * @param high
     * @return
     */
    public static int countInRange(int[]arr,int l,int h,int low,int high){
        int left=lowerBound_intarr(arr,l,h,low);
        int right=higherBound_intarr(arr,l,h,high);
        if(left<0){
            left=-left-1;
        }
        if(right<0){
            right=-right-1-1;
        }
        return right-left+1;
    }
}
