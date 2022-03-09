//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1302 👎 0


package editor.cn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class KthLargestElementInAnArray {
    public static void main (String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int[] test = new int[]{3,2,1,5,6,4};
        int res = solution.findKthLargest(test, 2);
        System.out.println(res);
    }
// TIME: 47min

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int findKthLargest(int[] nums, int k) {
//        // 快排， 每次丢弃一半的数据
//        // 不为空
//
//        int i = pivot(nums);
//        if (i+1==k) {
//            return nums[i];
//        } else if (i+1 < k) {
//            int[] nums1 = new int[nums.length-1-i];
//            System.arraycopy(nums, i+1, nums1, 0, nums.length-1-i);
//            return findKthLargest(nums1, k-i-1);  // 记得返回！
//        } else {
//            int[] nums2 = new int[i];
//            System.arraycopy(nums, 0, nums2, 0, i);
//            return findKthLargest(nums2, k);
//        }
//    }
//
//    private int pivot (int[] nums) {
//        int r = nums.length-1;
//        int i = 0;
//        int j = 0;
//        int tmp = 0;
//        while (j < r) {
//            if (nums[j] > nums[r]) {
//                tmp = nums[j];
//                nums[j] = nums[i];
//                nums[i] = tmp;
//                i++;
//            }
//            j++;
//        }
//        // 最后交换i和r
//        tmp = nums[r];
//        nums[r] = nums[i];
//        nums[i] = tmp;
//        return i;
//    }
//}

class Solution {
    private int res = 0;
    public int findKthLargest (int[] nums, int k) {
        pivot(nums, 0, nums.length-1, k);
        return res;
    }

    private void pivot(int[] nums, int p, int q, int t) { // 找在区间[p,q]上第t大的元素

        if (p > q) return;

        int i = p; // “大”区间尾
        for (int j = p; j < q; j++) {
            if (nums[j] >= nums[q]) {
                swap(nums, j, i);
                i++;
            }
        }

        swap(nums, q, i); // 找到了nums[i]是第i+1大的数

        if (i-p+1 == t) {
            res = nums[i];
        } else if (i-p+1 < t) {
            pivot(nums, i+1, q, t-(i-p+1));
        } else {
            pivot(nums, p, i-1, t);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[b];
        nums[b] = nums[a];
        nums[a] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
