package utils.algorithm;

/**
 * 基本数据类型的quicksort
 */
public class QuickSort {
    /**
     * 快速排序方法
     * @param array
     * @param low 包括
     * @param high 包括
     * @param ascending 升序/降序的参数 false是降序
     */
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

    /**
     * 分区方法，选择一个基准元素，将数组分为两部分
     * @param array
     * @param low
     * @param high
     * @param ascending
     * @return
     */
    private static int partition(int[] array, int low, int high, boolean ascending) {
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

    /**
     * 交换数组中的两个元素
     * @param array
     * @param i
     * @param j
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
