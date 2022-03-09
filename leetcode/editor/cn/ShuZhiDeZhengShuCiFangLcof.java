//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ）。不得使用库函数，同时不需要考虑大数问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2⁻² = 1/2² = 1/4 = 0.25 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -2³¹ <= n <= 2³¹-1 
// -10⁴ <= xⁿ <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 数学 👍 198 👎 0


package editor.cn;

import java.util.HashMap;

public class ShuZhiDeZhengShuCiFangLcof {
    public static void main (String[] args) {
        Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();
        double res = solution.myPow(8.95371, -1);
        System.out.println(res);
    }
// TIME:

//leetcode submit region begin(Prohibit modification and deletion)
//// "动规"，线性转对数
//class Solution {
//    public double myPow(double x, int n) {
//        if (x==1 || n==0) return 1;
//        if (n==1) return x;
//
//        double res = x;
//
//        int posN = Math.abs(n);
//        int i = 2;
//        while (i <= posN) {
//            res = res * res;
//            i = i * 2;
//        }
//
//        for (int k = 0; k < posN - i/2; k++) {
//            res *= x;
//        }
//
//        if (n < 0) {
//            res = 1 / res;
//        }
//        return res;
//    }
//}


// 递归解法
class Solution {
    public double myPow(double x, int n) {
//        if (n==0) return 1;
        if (n < 0) return 1 / (rPow(x, -1*(n+1))*x);
        return rPow(x, n);
    }
    private double rPow(double x, int n) {
        // n > 0
        // 对于偶数 P(x, n) = P(x, n/2) * P(x, n/2);
        // 对于奇数 P(x, n) = P(x, n/2) * P(x, n/2) * x
        if (n == 0) return 1;
//        if (n == 1) return x; // n==0时会堆栈溢出！来自于myPow中n==-1,因此即使在myPow中n==0时单独处理也不可行

        double halfPow = rPow(x, n/2);
        if (n % 2 == 1) {
            return halfPow*halfPow*x;
        } else {
            return halfPow*halfPow;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
