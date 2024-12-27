package Algorithm.slidewindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;
import java.util.Random;


/**
 * 如果要求支持左插入，左删除，右插入，右删除四种操作的滑动窗口，并且不可撤销，
 * 需要满足结合律,可以用于按位与，按位或gcd
 * 则可以用类似的方法，重构时改为从中点开始向左右重构即可保证复杂度为均摊 O(1)
 * 这里实现的是子数组的按位或
 *
 * 也就是用两个栈分别维护一个滑窗内左右的信息
 */
public class DoubleStack {
    /*
    注意：这个双栈没有维护滑动窗口端点的变化，所以l++,r++之类的变化要在调用者维护
     */
    int[]nums;
    /*
    例子
    左栈：nums[3],nums[3]|nums[2],nums[3]|nums[2]|nums[1] 顶
    右栈：nums[4],nums[4]|nums[5] 顶
     */
    Deque<Integer>leftStack;
    Deque<Integer>rightStack;

    public DoubleStack(int[]_nums){
        nums=_nums;
        leftStack=new ArrayDeque<>();
        rightStack=new ArrayDeque<>();
    }

    /**
     * 滑窗右端增
     * @param l
     * @param r
     */
    public void addToRight(int l,int r){
        if(rightStack.isEmpty()){
            rightStack.push(nums[r]);
        }else{
            rightStack.push(rightStack.peek()|nums[r]);
        }
    }

    /**
     * 滑窗左端增
     * @param l
     * @param r
     */
    public void addToLeft(int l,int r){
        if(leftStack.isEmpty()){
            leftStack.push(nums[l]);
        }else{
            leftStack.push(leftStack.peek()|nums[l]);
        }
    }

    /**
     * 滑窗右端删
     * @param l
     * @param r
     */
    public void removeFromRight(int l,int r){
        if(!rightStack.isEmpty()){
            rightStack.pop();
            return;
        }
        // 左栈倒右栈
        leftStack.clear();
        r--;//函数内部+，外面没加
        if(l<r){
            rightStack.clear();
            rightStack.add(nums[l+1]);
            for(int i=1;i<r-l;i++){
                rightStack.push(rightStack.peek()|nums[l+i+1]);
            }
        }
    }

    /**
     * 滑窗左端删
     * @param l
     * @param r
     */
    public void removeFromLeft(int l,int r){
        if(!leftStack.isEmpty()){
            leftStack.pop();
            return;
        }
        // 右栈倒左栈
        rightStack.clear();
        l++;//函数内部+，外面没加
        if(l<r){
            leftStack.clear();
            leftStack.add(nums[r-1]);
            for(int i=1;i<r-l;i++){
                leftStack.push(leftStack.peek()|nums[r-i-1]);
            }
        }
    }

    /**
     * 获取滑动窗口中维护的值
     * 也就是左栈的值和右栈的值相或
     * @return
     */
    public int getWindowValue(){
        int leftValue= Optional.ofNullable(leftStack.peek()).orElse(0);
        int rightValue=Optional.ofNullable(rightStack.peek()).orElse(0);
        return leftValue|rightValue;
    }

    @Override
    public String toString(){
        return "left: "+leftStack.toString()+
                "|right: "+rightStack.toString();
    }
}
