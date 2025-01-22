package math;

public class BitwiseOperation {
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
