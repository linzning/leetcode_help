package utils;

public class BinarySearch {
    /**
     * 二分查找int[],偏左
     * @param arr
     * @param low 包括在内
     * @param high 包括在内
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
     * 二分查找int[],偏右
     * @param arr
     * @param low
     * @param high
     * @param key
     * @return
     */
    public static int binarySearch_int_r(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (key == arr[mid]) {
                return mid;  // 找到了元素，返回索引
            }
            else if (key<arr[mid]) {
                high = mid - 1;  // 在左半边继续查找
            }
            else {
                low = mid + 1;   // 在右半边继续查找
            }
        }
        return high;
    }
}
