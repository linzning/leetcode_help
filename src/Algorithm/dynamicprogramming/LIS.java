package Algorithm.dynamicprogramming;

import utils.algorithm.BinarySearch;

public class LIS {
    /**
     * 最长递增子序列
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[]end_value=new int[n+1];
        int len=1;
        end_value[len]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>end_value[len])end_value[++len]=nums[i];
            else{
                int k= BinarySearch.binarySearch_intarr_l(end_value,1,len,nums[i]);
                end_value[k+1]=nums[i];
            }
        }
        return len;
    }


}
