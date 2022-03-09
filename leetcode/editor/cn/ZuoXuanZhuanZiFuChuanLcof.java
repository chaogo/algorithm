//English description is not available for the problem. Please switch to 
//Chinese. 
// Related Topics 数学 双指针 字符串 👍 144 👎 0


package editor.cn;
    
public class ZuoXuanZhuanZiFuChuanLcof {
    public static void main (String[] args) {
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
        String out = solution.reverseLeftWords("lr", 1);
        System.out.println(out);
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseLeftWords(String s, int n) {
        // s.length >= 2; k >= 1;
        // 额外空间， 一次遍历， 两次循环

        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length(); ++i) {
            res.append(s.charAt(i));
        }
        for (int i = 0; i < n; ++i) {
            res.append(s.charAt(i));
        }
        return new String(res);
        /*
        优化：只申请长度为n的空间，降低空间复杂度
        另外：每次只左旋一位，虽然时间复杂度大幅提高，但空间复杂度降为0，不是毫无价值
         */
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
