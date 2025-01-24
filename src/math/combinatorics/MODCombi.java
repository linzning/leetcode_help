package math.combinatorics;

/**
 * 在取余数的环境下使用组合数
 * 预处理后 O(1)查询组合数
 */
public class MODCombi {
    private static final int MOD = 1_000_000_007;
    private static final int MX = 100_001; // 根据题目数据范围修改

    private static final long[] F = new long[MX]; // F[i] = i!
    private static final long[] INV_F = new long[MX]; // INV_F[i] = i!^-1

    static {
        F[0] = 1;
        for (int i = 1; i < MX; i++) {
            F[i] = F[i - 1] * i % MOD;
        }

        INV_F[MX - 1] = pow(F[MX - 1], MOD - 2);
        for (int i = MX - 1; i > 0; i--) {
            INV_F[i - 1] = INV_F[i] * i % MOD;
        }
    }

    /**
     * 快速幂
     *
     * @param x
     * @param n
     * @return
     */
    private static long pow(long x, int n) {
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
        }
        return res;
    }

    /**
     * 组合数 从 n 个数中选 m 个数的方案数
     *
     * @param n
     * @param m
     * @return
     */
    private long combination(int n, int m) {
        return m < 0 || m > n ? 0 : F[n] * INV_F[m] % MOD * INV_F[n - m] % MOD;
    }

    private long permutation(int n, int m) {
        return m < 0 || m > n ? 0 : F[n] * INV_F[n - m] % MOD;
    }
}
