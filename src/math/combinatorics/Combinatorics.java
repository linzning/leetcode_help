package math.combinatorics;

/**
 * 没有取MOD的排列组合数
 */
public class Combinatorics {
    static long[]Factorial=new long[21];//预处理阶乘数组,大于20就溢出了
    static {
        Factorial[0]=1;
        for(int i=1;i<22;i++){
            Factorial[i]=Factorial[i-1]*i;
        }
    }

    // 计算排列数 P(n, r) = n! / (n-r)!
    public static long permutation(int n, int r) {
        if (n < r) {
            return 0; // 如果 n < r，排列数无意义，返回 0
        }
        return Factorial[n] / Factorial[n - r];
    }

    // 计算组合数 C(n, r) = n! / (r! * (n-r)!)
    public static long combination(int n, int r) {
        if (n < r) {
            return 0; // 如果 n < r，组合数无意义，返回 0
        }
        return Factorial[n] / (Factorial[r] * Factorial[n - r]);
    }
}
