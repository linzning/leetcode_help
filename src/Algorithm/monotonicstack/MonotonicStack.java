package Algorithm.monotonicstack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MonotonicStack {
    /**
     * 求右侧第一个大于的下标
     * @param arr
     * @return
     */
    public int[] getRightFirstGreaterIndex(int[] arr) {
        int n=arr.length;
        int[]ans=new int[n];
        Deque<Integer> stack=new LinkedList<>();// 存下标,保证值递增(栈头到尾)
        for(int i=0;i<n;i++){
            int x=arr[i];
            while (!stack.isEmpty()&&arr[stack.peek()]<x){
                ans[stack.pop()]=i;
            }
            stack.push(i);
        }
        return ans;
    }
}
