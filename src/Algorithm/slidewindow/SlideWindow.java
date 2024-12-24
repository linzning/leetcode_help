package Algorithm.slidewindow;

import java.util.HashSet;

public class SlideWindow {
    /**
     * 定长滑动窗口模板
     * 右侧一直增长，左侧只需i-k就可维护
     * https://leetcode.cn/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/
     */
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < (1 << k)) return false;
        HashSet<Long> hashSet = new HashSet<>();
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += (long) (s.charAt(i) == '1' ? 1 : 0) << (Math.min(i, k));
            if (i >= k) {
                count >>= 1;
            }
            if (i >= k - 1) {
                hashSet.add(count);
            }
        }
        return hashSet.size() == 1 << k;
    }

    /**
     * 不定长滑动窗口模板（最长）
     * 右侧不断增长，左侧维护一个left变量
     * https://leetcode.cn/problems/maximum-length-substring-with-two-occurrences/description/
     */
    public int maximumLengthSubstring(String s) {
        int[] count = new int[26];
        char[] str = s.toCharArray();
        int left = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            // 右侧伸长
            int b = str[i] - 'a';
            count[b]++;
            while (count[b] > 2) {
                // 左侧缩减
                count[str[left++] - 'a']--;
            }
            // ans+=left+1 越长越合法
            //
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }

    /**
     * 不定长滑动窗口模板（子数组个数）
     * 越长越合法 ans+=left+1;
     * 越短越合法 ans+=right-left+1;
     * 恰好 (>=k方案)-(>k方案)
     * https://leetcode.cn/problems/binary-subarrays-with-sum/
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum1=0;
        int sum2=0;
        int ans=0;
        int left1=0;
        int left2=0;
        for(int i=0;i<nums.length;i++){
            sum1+=nums[i];
            sum2+=nums[i];
            // >=goal的结果
            while (left1<i&&sum1-nums[left1]>=goal){
                sum1-=nums[left1++];
            }
            if(sum1>=goal){
                ans+=left1+1;
            }
            // >goal的结果
            while (left2<i&&sum2-nums[left2]>=goal+1){
                sum2-=nums[left2++];
            }
            if(sum2>=goal+1){
                ans-=left2+1;
            }
        }
        return ans;
    }
}
