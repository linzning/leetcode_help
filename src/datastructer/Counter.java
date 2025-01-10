package datastructer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 计数器类，暂时只支持Integer,Character
 * 支持减到负数
 * @param <T>
 */
public class Counter<T> {
    private final HashMap<T, Long> count;

    /* 计数器中正数，负数，0的量 */
    private int positive;
    private int negtive;
    private int zero;

    /* ----------------------初始化--------------------------- */
    public Counter() {
        count = new HashMap<>();
    }

    public Counter(HashMap<T,Long>map){
        count=map;
    }

    public Counter(int[] nums) {
        count=new HashMap<>();
        add(nums);
    }

    public Counter(List<Integer> nums) {
        count=new HashMap<>();
        add(nums);
    }

    public Counter(char[] nums) {
        count = new HashMap<>();
        add(nums);
    }

    public Counter(String s) {
        count = new HashMap<>();
        add(s);
    }

    /*------------------------集合运算----------------------*/

    /**
     * this是否覆盖_count
     * @param _count
     * @return
     */
    public boolean isCover(Counter<T> _count){
        for(Map.Entry<T,Long> entry:_count.getCounts().entrySet()){
            if(entry.getValue()>=0){
                if(!count.containsKey(entry.getKey())||
                        count.get(entry.getKey())<entry.getValue())return false;
            }
        }
        return true;
    }

    /**
     * 合并另一个counter
     * @param count
     * @return
     */
    public void merge(Counter<T>count){
        for(Map.Entry<T,Long>entry:count.getCounts().entrySet()){
            this.count.merge(entry.getKey(), entry.getValue(), Long::sum);
        }
    }

    /* ----------------------------增减------------------------ */

    public void add(int[]nums){
        for(int n:nums)add((T) Integer.valueOf(n));
    }

    public void add(List<Integer> nums){
        for(int n:nums)add((T) Integer.valueOf(n));
    }

    public void add(char[] s){
        for(char c:s)add((T)Character.valueOf(c));
    }

    public void add(String s){
        for(char c:s.toCharArray())add((T)Character.valueOf(c));
    }

    /**
     * 增加次数
     * @param num
     */
    public void add(T num) {
        if(!count.containsKey(num)){
            positive++;
        }else{
            Long pre=count.get(num);
            if(pre==-1){
                negtive--;
                zero++;
            }
            if(pre==0){
                zero--;
                positive++;
            }
        }
        count.merge(num,1L,Long::sum);
    }

    public void sub(int[] nums){
        for(int n:nums)sub((T) Integer.valueOf(n));
    }

    public void sub(String s){
        for(char c:s.toCharArray())sub((T)Character.valueOf(c));
    }

    /**
     * 减少次数
     * @param num
     */
    public void sub(T num){
        if(!count.containsKey(num)){
            negtive++;
        }else{
            Long pre=count.get(num);
            if(pre==1){
                positive--;
                zero++;
            }
            if(pre==0){
                zero--;
                negtive++;
            }
        }
        count.merge(num,-1L,Long::sum);
    }

    /**
     * 获取次数
     * @param num
     * @return
     */
    public Long get(T num) {
        return count.getOrDefault(num, 0L);
    }

    public HashMap<T, Long> getCounts() {
        return count;
    }

    @Override
    public String toString() {
        return count.toString().replaceAll("=", ":");
    }

    public int getPositive() {
        return positive;
    }

    public int getNegtive() {
        return negtive;
    }

    public int getZero() {
        return zero;
    }
}
