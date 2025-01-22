package Algorithm.dynamicprogramming;

public class IntervalDP {
    /**
     * 最长回文子序列
     * @param s
     * @return
     */
    public static int longestPalindromeSubseq(String s) {
        char[]str=s.toCharArray();
        int n=s.length();
        int[][]dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        for(int len=2;len<=n;len++){
            for(int i=0;i+len<=n;i++){
                int j=i+len-1;
                if(str[i]==str[j]){
                    dp[i][j]=dp[i+1][j-1]+2;
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }

    /**
     * 最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        char[]str=s.toCharArray();
        int n=s.length();
        int left=0,right=0;
        boolean[][]dp=new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                if(str[i]==str[j]&&(j==i+1||dp[i+1][j-1])){
                    dp[i][j]=true;
                    left=i;
                    right=j;
                }
            }
        }
        return s.substring(left,right+1);
    }

    /**
     * 预处理所有子数组是否是回文串
     * @param _s
     * @return
     */
    public boolean[][] preprocessSubarraysPalindrome(String _s){
        int n=_s.length();
        char[]s=_s.toCharArray();
        //预处理回文串
        boolean[][]isHuiWen=new boolean[n][n];//是否能构成回文串
        for(int j=0;j<n;j++){
            isHuiWen[j][j]=true;
            for(int i=j-1;i>=0;i--){
                //头尾相等&&(长度为2或者中间也是回文)
                if(s[i]==s[j]&&(j==i+1||isHuiWen[i+1][j-1])){
                    isHuiWen[i][j]=true;
                }
            }
        }
        return isHuiWen;
    }
}
