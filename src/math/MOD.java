package math;

import java.util.List;

/**
 * MOD运算的宏
 * * / % 优先级相同
 */
public class MOD {
    static int MOD=(int)1e9+7;
    long add(long a,long b){
        return (a+b)%MOD;
    }
    long sub(long a,long b){
        return (a-b+MOD)%MOD;
    }

    /**
     * 乘法
     * @param a
     * @param b
     * @return
     */
    long multi(long a,long b){
        return a*b%MOD;
    }

    /**
     * 多个数乘法，每次都要取MOD
     * @param nums
     * @return
     */
    long multi_arr(List<Long>nums){
        long ans=1;
        for(long n:nums){
            ans=ans*n%MOD;
        }
        return ans;
    }

    /**
     * 除（MOD 是质数且 b 不是 MOD 的倍数）
     * @param a
     * @param b
     * @return
     */
    long div(long a,long b){
        return  a * qpow(b, MOD - 2, MOD) % MOD;
    }

    /**、
     * 把任意整数 a 取模到 [0,MOD-1] 中，无论 a 是正是负
     * @param a
     * @return
     */
    long normal(long a){
        return (a%MOD+MOD)%MOD;
    }

    /**
     * 快速幂计算 (x^y) % mod
     * @param x
     * @param y
     * @param mod
     * @return
     */
    private long qpow(long x,int y,int mod){
        long result = 1;
        while (y > 0) {
            if (y % 2 == 1) {
                result = result * x % mod;
            }
            x = x * x % mod;
            y /= 2;
        }
        return result;
    }
}
