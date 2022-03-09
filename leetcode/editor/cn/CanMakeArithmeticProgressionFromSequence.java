//给你一个数字数组 arr 。 
//
// 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。 
//
// 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,5,1]
//输出：true
//解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
// 
//
// 示例 2： 
//
// 输入：arr = [1,2,4]
//输出：false
//解释：无法通过重新排序得到等差数列。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 1000 
// -10^6 <= arr[i] <= 10^6 
// 
// Related Topics 数组 排序 👍 15 👎 0


package editor.cn;

import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence {
    public static void main (String[] args) {
        Solution solution = new CanMakeArithmeticProgressionFromSequence().new Solution();
    }
// TIME: 17min

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public boolean canMakeArithmeticProgression(int[] arr) {
//        // 冒泡排序，可以提前终止
//        // 长度大于等于2
//
//        int n = arr.length;
//        int diff = 0;
//        for (int i = n-1; i >= 0; i--) { // 最后一位虽然排序不重要了但下面判断还是有意义的
//            for (int j = 0; j < i; j++) {
//                if (arr[j] > arr[j+1]) {
//                    int tmp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = tmp;
//                }
//            }
//            if (i == n-2) {
//                diff = arr[i+1] - arr[i];
//            } else if (i < n-2 && arr[i+1] - arr[i] != diff){
//                return false;
//            }
//        }
//        return true;
//
//    }
//}

//// 选择排序，提前终止
//class Solution {
//    public boolean canMakeArithmeticProgression(int[] arr) {
//        // 长度大于等于2
//
//        int n = arr.length;
//        int diff = 0;
//        int minId;
//        int tmp;
//        for (int i = 0; i < n; i++) { // i为已排序区间后的第一个元素
//            minId = i;
//            for (int j = i; j < n; j++) { // 对未排序区间进行遍历
//                if (arr[j] < arr[minId]) {
//                    minId = j;
//                }
//            }
//            // 交换
//            tmp = arr[i];
//            arr[i] = arr[minId];
//            arr[minId] = tmp;
//            // 判断是否满足等差
//            if (i == 1) {
//                diff = arr[i] - arr[i-1];
//            } else if (i > 1 && arr[i] - arr[i-1] != diff) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//}

// 直接调用排序函数
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i-1] != diff) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
