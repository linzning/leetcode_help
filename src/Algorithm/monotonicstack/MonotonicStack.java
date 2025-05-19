package Algorithm.monotonicstack;

import java.util.*;

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
        Deque<Integer> stack=new LinkedList<>();// 存下标,保证值递增(栈顶到底)
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
     * 左侧最远更小值，只能求宽度的最大值.不能求接雨水类的最大值
     * @param arr
     * @return
     * [962. 最大宽度坡 - 力扣（LeetCode）](https://leetcode.cn/problems/maximum-width-ramp/description/)
     */
    public int globalFarthestSmallerValue(int[]arr){
        // 使用单调栈保存递减的索引(栈底到栈顶)
        // 单调栈中记录的是*从后往前*每个大分段 “坡底” 所在的位置。
        /*
         如[6,1,8,2,0,5]中[6,1,0]递减，栈中存的就是[0,1,4]
                                     6为[6]的坡底，1是的[1,8,2]的坡底，0是[0,5]的坡底
                                     对于形成的坡底，如对2，不如选更左侧1
         */
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


    /**
     * [11. 盛最多水的容器 - 力扣（LeetCode）](https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked)
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        _height=height;
        int n=height.length;
        //数组模拟栈
        List<Integer> stack=new ArrayList<>();
        int maxArea=0;
        //栈中维护递增下标
        for(int i=0;i<n;i++){
            if(stack.isEmpty()||height[i]>height[stack.get(stack.size()-1)]){
                stack.add(i);
            }
        }
        //找左侧最远更大值
        for(int i=n-1;i>=0;i--){
            int index=stack.get(binaryS_l(stack,height[i]));
            if(height[index]>=height[i]){
                maxArea=Math.max(maxArea,(i-index)*height[i]);
            }
        }
        stack.clear();
        //栈中维护递增下标
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()||height[i]>height[stack.get(stack.size()-1)]){
                stack.add(i);
            }
        }
        //找右侧最远更大值
        for(int i=0;i<n;i++){
            int index=stack.get(binaryS_r(stack,height[i]));
            if(height[index]>=height[i]){
                maxArea=Math.max(maxArea,(index-i)*height[i]);
            }
        }
        return maxArea;
    }
    int []_height;
    public int binaryS_l(List<Integer>list,int num){
        int l=0,r=list.size()-1;
        while (l<=r){
            int mid=l+((r-l)>>1);
            if(_height[list.get(mid)]>=num){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public int binaryS_r(List<Integer>list,int num){
        int l=0,r=list.size()-1;
        while (l<=r){
            int mid=l+((r-l)>>1);
            if(_height[list.get(mid)]>=num){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }

}
