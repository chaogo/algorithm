//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 529 👎 0


package editor.cn;
    
public class ShuZuZhongDeNiXuDuiLcof {
    public static void main (String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
        int[] test = new int[]{7,5,6,4};
        int res = solution.reversePairs(test);
        System.out.println(res);
    }
// TIME: 70min

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int cnt = 0;
    public int reversePairs(int[] nums) {
        // 暴力解法超时
        // 归并排序的过程中记录逆序对的个数
        // 两边各自改变顺序并不改变跨越两边的逆序对个数
        int n = nums.length;
        mergeSort(nums, 0, n-1);
        return cnt;
    }

    private void mergeSort(int[] nums, int p, int r) {
        if (p >= r) return;

        int q = p + (r-p)/2;
        mergeSort(nums, p, q);
        mergeSort(nums, q+1, r);
        merge(nums, p, q, r);
    }

    private void merge(int[] nums, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int k = 0;
        int[] tmp = new int[r-p+1];
        while (i <= q && j <= r) {
            if (nums[i] <= nums[j]) { // 每次写nums[i]时，此时前面有多少个"nums[j]"，nums[i]就有多少个逆序对，因此cnt+=j
                cnt += j-q-1;
                tmp[k++] = nums[i++];
            } else {
                // cnt += q-i+1 // 从j出发的另一种写法
                tmp[k++] = nums[j++];
            }
        }
        while (i <= q) {
            cnt += j-q-1;
            tmp[k++] = nums[i++];
        }
        while (j <= r) {
            tmp[k++] = nums[j++];
        }
        for (i = 0; i <= r-p; i++) {
            nums[p+i] = tmp[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
