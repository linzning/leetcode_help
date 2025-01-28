package Algorithm.dynamicprogramming;

public class MaxSubSum {
    public static int maxSubarraySum(int[]nums){
        // 初始化当前最大和以及全局最大和
        int currentMax = 0;
        int globalMax = 0;
        for (int i = 0; i < nums.length; i++) {
            // 更新当前最大和，要么加上当前元素，要么从当前元素重新开始
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            // 更新全局最大和
            globalMax = Math.max(globalMax, currentMax);
        }
        return globalMax;
    }
}
