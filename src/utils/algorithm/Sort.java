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

}
