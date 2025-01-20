package utils;

import java.util.Arrays;

public class MyMath {
//    public int minMaxSums(int[] nums, int k) {
//        int MOD = 1_000_000_007;
//        int n = nums.length;
//        long totalSum = 0;
//
//        Arrays.sort(nums);
//
//        // 预计算所有阶乘和阶乘的逆元
//        long[] fact = new long[n + 1];
//        long[] invFact = new long[n + 1];
//        fact[0] = invFact[0] = 1;
//        for (int i = 1; i <= n; i++) {
//            fact[i] = fact[i - 1] * i % MOD;
//        }
//        invFact[n] = modInverse(fact[n], MOD); // 计算 n! 的逆元
//        for (int i = n - 1; i >= 1; i--) {
//            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
//        }
//
//        // 计算每个元素作为最小值和最大值时的贡献
//        for (int i = 0; i < n; i++) {
//            for (int len = 1; len <= k; len++) {
//                long combi=combination(n - i - 1, len - 1,MOD,fact,invFact)% MOD;
//                long minContrib = ((long) nums[i] *combi) % MOD;
//                totalSum = (totalSum + minContrib) % MOD;
//                combi=combination(i, len - 1,MOD,fact,invFact)% MOD;
//                long maxContrib = ((long) nums[i] *combi) % MOD;
//                totalSum = (totalSum + maxContrib) % MOD;
//            }
//        }
//        return (int) totalSum;
//    }
//
//    // 计算组合数 C(n, r) = n! / (r! * (n-r)!) 通过模运算
//    private static long combination(int n, int r, int MOD, long[] fact, long[] invFact) {
//        if (n < r || r < 0) {
//            return 0;
//        }
//        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
//    }
//
//    // 计算 x^(-1) % mod 通过费马小定理
//    private static long modInverse(long x, int mod) {
//        return power(x, mod - 2, mod);
//    }
//
//    // 快速幂算法，计算 (x^y) % mod
//    private static long power(long x, int y, int mod) {
//        long result = 1;
//        while (y > 0) {
//            if (y % 2 == 1) {
//                result = result * x % mod;
//            }
//            x = x * x % mod;
//            y /= 2;
//        }
//        return result;
//    }

    // 计算阶乘
    private static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // 计算排列数 P(n, r) = n! / (n-r)!
    public static long permutation(int n, int r) {
        if (n < r) {
            return 0; // 如果 n < r，排列数无意义，返回 0
        }
        return factorial(n) / factorial(n - r);
    }

    // 计算组合数 C(n, r) = n! / (r! * (n-r)!)
    public static long combination(int n, int r) {
        if (n < r) {
            return 0; // 如果 n < r，组合数无意义，返回 0
        }
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    /**
     * 最大公约数
     * @param a
     * @param b
     * @return
     */
    public static int GCD(int a,int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * 最小公倍数
     * @param a
     * @param b
     * @return
     */
    public static int lcm(int a, int b) {
        return a * b / GCD(a, b);
    }

    /**
     * 数组最大值，null返回-1
     * @param nums
     * @return
     */
    public static int max_intarr(int[]nums){
        return Arrays.stream(nums).max().orElse(-1);
    }

    public static int max_intMulti(int... nums){
        return Arrays.stream(nums).max().orElse(-1);
    }

    public static int min_intMulti(int... nums){
        return Arrays.stream(nums).min().orElse(-1);
    }

    /**
     * 素数计数
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        /*
        埃氏筛算法
        质数的倍数是合数，所以当遍历到质数时，把它的所有倍数筛去
        优化：从$i*i $开始筛，因为$2*i , 3*i$已经被2 ，3筛过了
         */
        int[]isprime=new int[n];
        Arrays.fill(isprime,1);
        int ans=0;
        for(int i=2;i<n;i++){
            if(isprime[i]==1){
                ans++;
                if((long)i*i<n) {
                    for (int j = i * i; j < n; j += i) {
                        isprime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 求最低位的1
     * @param num
     * @return
     */
    public static int lowBit(int num){
        return num&-num;
    }

    /**
     * 10进制数字转二进制字符串
     * @param num
     * @return
     */
    public static String int10_2(int num){
        StringBuilder sb=new StringBuilder();
        while (num>0){
            sb.append(num%2);
            num/=2;
        }
        // Long.toBinaryString(num); Java自带的转二进制字符串
        // Integer也有
        return sb.reverse().toString();
    }

    /**
     * java有自带的bitCount函数
     * @param a
     * @return
     */
    private static int _bitCount(int a){
        return Long.bitCount(a);
    }
}