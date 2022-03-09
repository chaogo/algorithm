//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 423 👎 0


package editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfTwoArrays {
    public static void main (String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
    }
// TIME:

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j])) {
                list.add(nums2[j]);
                set.remove(nums2[j]); //避免重复
            }
        }

        int[] res = new int[list.size()];
        int r = 0;
        for (int k : list) {
            res[r] = k;
            r++;
        }
        return res;
    }
}
// 另 排序+双指针
// 扩展：k个数组求交集： 两两求交集；排序+多指针；排序去重+哈希表记录元素出现次数；
//leetcode submit region end(Prohibit modification and deletion)

}
    
