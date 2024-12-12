package datastructer;

public class PreSum {
    /**
     * 求一维前缀和，第二项才是原数组的第一项，第一项是0
     * @param nums
     * @return
     */
    public static int[] presum_1(int[]nums){
        int[]ans=new int[nums.length+1];
        ans[0]=0;
        for(int i=1;i<=nums.length;i++){
            ans[i]=ans[i-1]+nums[i-1];
        }
        return ans;
    }

    /**
     * 前缀异或和
     * @param nums
     * @return
     */
    public static int[] preXor_1(int[]nums){
        int[]preXor=new int[nums.length+1];
        preXor[0]=0;
        for(int i=1;i<=nums.length;i++){
            preXor[i]=preXor[i-1]^nums[i-1];
        }
        return preXor;
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
