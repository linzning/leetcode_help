package utils.algorithm;

import java.util.Arrays;

public class Sort {
    /**
     * 二维数组根据，第二维某一位的值排序
     * @param nums
     */
    private static void _sort_2_n(int[][]nums){
        //按第二维第一位升序
        //Arrays.sort也只能对非基本数据类型使用，不然只能简单的升序或降序
        Arrays.sort(nums,(a,b)->a[0]-b[0]);
    }

    // 快速排序方法，接受升序/降序的参数
    public static void quickSort(int[] array, int low, int high, boolean ascending) {
        if (low < high) {
            // 获取基准元素的索引
            int pivotIndex = partition(array, low, high, ascending);

            // 递归排序基准元素左侧部分
            quickSort(array, low, pivotIndex - 1, ascending);

            // 递归排序基准元素右侧部分
            quickSort(array, pivotIndex + 1, high, ascending);
        }
    }

    // 分区方法，选择一个基准元素，将数组分为两部分
    public static int partition(int[] array, int low, int high, boolean ascending) {
        // 选择最右边的元素作为基准
        int pivot = array[high];
        int i = low - 1;

        // 根据升序或降序进行比较
        for (int j = low; j < high; j++) {
            if ((ascending && array[j] <= pivot) || (!ascending && array[j] >= pivot)) {
                i++;
                // 交换 array[i] 和 array[j]
                swap(array, i, j);
            }
        }

        // 将基准元素放到正确的位置
        swap(array, i + 1, high);
        return i + 1; // 返回基准元素的索引
    }

    // 交换数组中的两个元素
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
