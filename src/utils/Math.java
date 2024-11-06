package utils;

public class Math {
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
}