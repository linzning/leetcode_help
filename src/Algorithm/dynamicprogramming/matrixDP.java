package Algorithm.dynamicprogramming;

public class matrixDP {
    //网格图方向
    static int[][]dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    /**
     * [931. 下降路径最小和 - 力扣（LeetCode）](https://leetcode.cn/problems/minimum-falling-path-sum/description/)
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                else if (j == n - 1) dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1])+matrix[i][j];
                else dp[i][j]=Math.min(Math.min(dp[i - 1][j], dp[i - 1][j + 1]),dp[i-1][j-1])+matrix[i][j];
            }
        }
        for(int i=0;i<n;i++){
            ans=Math.min(ans,dp[m-1][i]);
        }
        return ans;
    }
}
