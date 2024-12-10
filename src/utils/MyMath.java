package utils;

import java.util.Arrays;

public class MyMath {
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
     * 向上去整，并强转整数
     * @param a
     * @return
     */
    private static long _ceil(double a){
        return (long) Math.ceil(a);
    }

    /**
     * 向下去整，并强转整数
     * @param a
     * @return
     */
    private static long _floor(double a){
        return (long) Math.floor(a);
    }
}