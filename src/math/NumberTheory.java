package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberTheory {
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


    static final int N = 1000000; // Adjust N based on your needs
    List<Integer> pri = new ArrayList<>();//n以内质数
    boolean[] notPrime = new boolean[N];
    int[] phi = new int[N];//欧拉函数值

    /**
     * 线性筛法
     * @param n
     */
    public void countPrime(int n) {
        phi[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (!notPrime[i]) {
                pri.add(i);
                phi[i] = i - 1;
            }
            for (int pri_j : pri) {
                if (i * pri_j > n) break;
                notPrime[i * pri_j] = true;
                if (i % pri_j == 0) {
                    phi[i * pri_j] = phi[i] * pri_j;
                    break;
                }
                phi[i * pri_j] = phi[i] * phi[pri_j];
            }
        }
    }
}