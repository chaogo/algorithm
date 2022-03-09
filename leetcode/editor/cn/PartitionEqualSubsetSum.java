//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 1141 👎 0


package editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {
    public static void main (String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        int[] test = {2,2,3,5};
        boolean res = solution.canPartition(test);
        System.out.println(res);
    }
// TIME:

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 官方题解
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target+1]; // 排除所以可以提前得出结论的情况，最后确有必要时才建立数组，-》 降低空间复杂度
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (dp[target-num]) return true;
            for (int j = target-1; j >= num; --j) {
                dp[j] |= dp[j-num];
            }
        }
        return false;
    }
        // boolean array
//    public boolean canPartition(int[] nums) {
//        // 即 能否装一部分至背包使得背包里的和为总和的一半
//        // dp[j] = dp[j] || dp[j-weight[i]]
//        int sum = Arrays.stream(nums).sum();
//        if (sum % 2 == 1 || nums.length == 1) return false;
//        int target = sum / 2;
//        boolean[] dp = new boolean[target+1];
//
//        // weight[0]
//        dp[0] = true;
//        if (nums[0] > target) return false;
//        if (nums[0] == target) return true;
//        dp[nums[0]] = true;
//
//        // after
//        for (int i = 1; i < nums.length; i++) {
//            // nums[i] 直接造成结果
//            if (nums[i] > target) return false;
//            if (nums[i] == target || dp[target-nums[i]]) return true;
//            // nums[i] 更新可达状态
//            for (int j = target-1; j >= nums[i]; j--) {
//                if (!dp[j]) dp[j] = dp[j-nums[i]];
//            }
//        }
//        return false;
//    }

    // hashSet: 更慢，更费空间（可能由于temSet)
//    public boolean canPartition(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        int sum = Arrays.stream(nums).sum();
//        if (sum % 2 == 1 || nums.length == 1) return false;
//        int target = sum / 2;
//        set.add(0);
//        set.add(nums[0]);
//
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] > target) return false;
//            if (nums[i] == target) return true;
//            Set<Integer> temSet = new HashSet<>();
//            for (int e : set) {
//                if (e+nums[i] == target) return true;
////                set.add(e+nums[i]); // 会造成ConcurrentModificationException
//                temSet.add(e+nums[i]);
//            }
//            set.addAll(temSet);
//        }
//
//        return false;
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
