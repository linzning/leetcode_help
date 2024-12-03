package slidewindow;

import java.util.HashSet;

public class SlideWindow {
    /**
     * 定长滑动窗口模板
     * 右侧一直增长，左侧只需i-k就可维护
     * https://leetcode.cn/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/
     */
    public boolean hasAllCodes(String s, int k) {
        if(s.length()<(1<<k))return false;
        HashSet<Long> hashSet=new HashSet<>();
        long count=0;
        for(int i=0;i<s.length();i++){
            count+= (long) (s.charAt(i) == '1' ? 1 : 0) <<(Math.min(i,k));
            if(i>=k){
                count>>=1;
            }
            if(i>=k-1){
                hashSet.add(count);
            }
        }
        return hashSet.size()==1<<k;
    }
    /**
     * 不定长滑动窗口模板（最长）
     * 右侧不断增长，左侧维护一个left变量
     * https://leetcode.cn/problems/maximum-length-substring-with-two-occurrences/description/
     */
    public int maximumLengthSubstring(String s) {
        int[]count=new int[26];
        char[]str=s.toCharArray();
        int left=0;
        int ans=0;
        for(int i=0;i<s.length();i++) {
            // 右侧伸长
            int b = str[i]-'a';
            count[b]++;
            while (count[b] > 2) {
                // 左侧缩减
                count[str[left++]-'a']--;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
