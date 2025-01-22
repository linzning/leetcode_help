package Algorithm.monotonicstack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MonotonicStack {
    /**
     * 求右侧第一个大于的下标
     * @param arr
     * @return
     *
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

    /**
     * 全局最远更小值
     * @param arr
     * @return
     * [962. 最大宽度坡 - 力扣（LeetCode）](https://leetcode.cn/problems/maximum-width-ramp/description/)
     */
    public int globalFarthestSmallerValue(int[]arr){
        // 使用单调栈保存递减的索引
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || arr[stack.peek()] > arr[i]) {
                stack.push(i);
            }
        }
        int maxWidth = 0;
        // 从数组末尾向前遍历，尝试更新最大坡宽
        for (int j = arr.length - 1; j >= 0; j--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[j]) {
                maxWidth = Math.max(maxWidth, j - stack.pop());
            }
        }
        return maxWidth;
    }
}
