package math.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutation {
    /**
     * 去重全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = Arrays.asList(new Integer[nums.length]); // 所有排列的长度都是 n
        boolean[] onPath = new boolean[n]; // onPath[j] 表示 nums[j] 是否已经填入排列
        dfs(0, nums, path, onPath, ans);
        return ans;
    }

    // i 表示当前要填排列的第几个数
    private void dfs(int i, int[] nums, List<Integer> path, boolean[] onPath, List<List<Integer>> ans) {
        if (i == nums.length) { // 填完了
            ans.add(new ArrayList<>(path));
            return;
        }
        // 枚举 nums[j] 填入 path[i]
        for (int j = 0; j < nums.length; j++) {
            // 如果 nums[j] 已填入排列，continue
            // 如果 nums[j] 和前一个数 nums[j-1] 相等，且 nums[j-1] 没填入排列，continue
            if (onPath[j] || j > 0 && nums[j] == nums[j - 1] && !onPath[j - 1]) {
                continue;
            }
            path.set(i, nums[j]); // 填入排列
            onPath[j] = true; // nums[j] 已填入排列（注意标记的是下标，不是值）
            dfs(i + 1, nums, path, onPath, ans); // 填排列的下一个数
            onPath[j] = false; // 恢复现场
            // 注意 path 无需恢复现场，因为排列长度固定，直接覆盖就行
        }
    }

}
