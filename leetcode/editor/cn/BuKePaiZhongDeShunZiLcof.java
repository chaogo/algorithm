//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// Related Topics 数组 排序 👍 159 👎 0


package editor.cn;

import java.util.HashSet;

public class BuKePaiZhongDeShunZiLcof {
    public static void main (String[] args) {
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
        int[] test = new int[]{0,0,1,2,5};
        boolean res = solution.isStraight(test);
        System.out.println(res);
    }
// TIME:

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
        /*
         一遍扫描，
         1.跳过0；
         2.除0之外是否有重复；
         3.同时记录除0之外最小与最大
         */

        HashSet<Integer> bag = new HashSet<>();
        // 可以用更简单的一一映射布尔数组来记录是否有重复
//        boolean[] dup = new boolean[14];
        int max = -1;
        int min = 14;

        for (int k: nums) {
            if (k == 0) {
                continue;
            }
            if (!bag.add(k)) {
                return false;
            }
            if (k > max) max = k;
            if (k < min) min = k;
        }

        return max - min <= 4;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
