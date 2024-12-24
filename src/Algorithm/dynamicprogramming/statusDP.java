package Algorithm.dynamicprogramming;

/**
 * 一般定义 $ f[i][j] $表示前缀  $ a[:i] $ 在状态$ j $下的最优值。一般 $ j $ 都很小。代表题目是「买卖股票」系列
 */
public class statusDP {

    /**
     * [3259. 超级饮料的最大强化能量 - 力扣（LeetCode）]
     * (https://leetcode.cn/problems/maximum-energy-boost-from-two-drinks/description/)
     * @param energyDrinkA
     * @param energyDrinkB
     * @return
     */
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n=energyDrinkA.length;
        long[][]dp=new long[n][2];//dp[i][j]表示在i之前时间的最大能量，j=0或1表示A或B
        dp[0][0]=energyDrinkA[0];
        dp[0][1]=energyDrinkB[0];
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0]+energyDrinkA[i],dp[i-1][1]);
            dp[i][1]=Math.max(dp[i-1][1]+energyDrinkB[i],dp[i-1][0]);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}
