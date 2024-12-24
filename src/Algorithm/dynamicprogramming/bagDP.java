package Algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * https://blog.csdn.net/qq_52354698/article/details/122508598)
 */
public class bagDP {
    /*
    0-1背包
    for(int i = 1; i <= n; i ++ )
	    for(int j = m; j >= v[i]; j -- )
		    f[j] = max(f[j], f[j - v[i]] + w[i]);
     */

    /**
     * [2915. 和为目标值的最长子序列的长度 - 力扣（LeetCode）]
     * (https://leetcode.cn/problems/length-of-the-longest-subsequence-that-sums-to-target/description/)
     * 必须装满的情况
     * @param nums
     * @param target
     * @return
     */
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int INF=Integer.MIN_VALUE/2;
        int n=nums.size();
        int[]dp=new int[target+1];
        Arrays.fill(dp,INF);
        dp[0]=0;//只有dp[0]是有效状态
        for(int i=0;i<n;i++){
            for(int j=target;j>=nums.get(i);j--){
                dp[j]=Math.max(dp[j],dp[j-nums.get(i)]+1);
                if(dp[j]<0)dp[j]=INF;//不是从dp[0]转移过来的
            }
        }
        if(dp[target]<0)return -1;
        return dp[target];
    }


}
