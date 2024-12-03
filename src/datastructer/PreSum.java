package datastructer;

public class PreSum {
    /**
     * 求一维前缀和，第二项才是原数组的第一项，第一项是0
     * @param nums
     * @return
     */
    public static int[] presum_1(int[]nums){
        int[]ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=(i==0?0:ans[i-1])+nums[i];
        }
        return ans;
    }

    /**
     * 求二维前缀和数组//todo
     * @param nums
     * @return
     */
    public static int[][] presum_2(int[][]nums){
        int m=nums.length;
        int n=nums[0].length;
        int[][]ans=new int[m][n];
        return ans;
    }
}
