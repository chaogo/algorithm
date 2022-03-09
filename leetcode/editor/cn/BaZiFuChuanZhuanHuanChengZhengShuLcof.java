//English description is not available for the problem. Please switch to 
//Chinese. Related Topics 字符串 👍 102 👎 0


package editor.cn;
    
public class BaZiFuChuanZhuanHuanChengZhengShuLcof {
    public static void main (String[] args) {
        Solution solution = new BaZiFuChuanZhuanHuanChengZhengShuLcof().new Solution();
        int res  = solution.strToInt("-2147483648");
        System.out.println(res);
    }
// atoi
// TIME:

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strToInt(String str) {
        // "  ", "-91283472332", "   -42", "4193 with words", "042", "+-2", "+    42", "-2147483648"
        // 一次遍历，提前终止

        long res = 0; // 也可以用int,不过需要提前一个循环做预判处理！！
        int sign = 1;
        char curr;
        int i = 0;

        while (i < str.length()) { // 处理空格
            curr = str.charAt(i);
            if (curr == ' '){
                i++;
            } else if (curr == '+') {
                i++;
                break;
            } else if (curr == '-') {
                sign = -1;
                i++;
                break;
            } else if (curr >= '0' && curr <= '9'){
                break;
            } else {
                return 0;
            }
        }

        while (i < str.length()) { // 开始处理数字
            curr = str.charAt(i);
            if (curr >= '0' && curr <= '9') {
                res = res*10 + (int) curr-'0';
                // 数字超出范围
                if (sign*res > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (sign*res < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
            i++;
        }
        int finalRes = ((int) res)*sign;
        return finalRes;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
