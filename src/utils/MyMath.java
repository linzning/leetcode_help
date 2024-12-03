package utils;

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


}