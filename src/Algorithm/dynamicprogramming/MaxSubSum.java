package Algorithm.dynamicprogramming;

public class MaxSubSum {
    /**
     * 求最大子数组(kadane算法)
     * @param nums
     * @return [左边界，右边界，最大子数组和](边界左闭右闭)
     */
    public static int[] maxSubarraySum_bound(int[]nums){
        // 初始化当前最大和以及全局最大和
        int currentMax = 0;
        int globalMax = 0;//如要求不能为空则初始化为-INF
        int left=-1;
        int right=-1;
        for (int i = 0; i < nums.length; i++) {
            // 更新当前最大和，要么加上当前元素，要么从当前元素重新开始
            if(currentMax<=0){
                left=i;
                currentMax=nums[i];
            }else {
                currentMax+=nums[i];
            }
            // 更新全局最大和
            if(currentMax>globalMax){
                right=i;
                globalMax=currentMax;
            }
        }
        return new int[]{left,right,globalMax};
    }

    public static int maxSubarraySum(int[]nums){
        // 初始化当前最大和以及全局最大和
        int currentMax = 0;
        int globalMax = 0;//如要求不能为空则初始化为-INF
        for (int i = 0; i < nums.length; i++) {
            // 更新当前最大和，要么加上当前元素，要么从当前元素重新开始
            currentMax=Math.max(0,currentMax)+nums[i];
            // 更新全局最大和
            globalMax=Math.max(globalMax,currentMax);
        }
        return globalMax;
    }
}
