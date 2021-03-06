//English description is not available for the problem. Please switch to 
//Chinese. Related Topics å­ç¬¦ä¸² ð 102 ð 0


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
        // ä¸æ¬¡éåï¼æåç»æ­¢

        long res = 0; // ä¹å¯ä»¥ç¨int,ä¸è¿éè¦æåä¸ä¸ªå¾ªç¯åé¢å¤å¤çï¼ï¼
        int sign = 1;
        char curr;
        int i = 0;

        while (i < str.length()) { // å¤çç©ºæ ¼
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

        while (i < str.length()) { // å¼å§å¤çæ°å­
            curr = str.charAt(i);
            if (curr >= '0' && curr <= '9') {
                res = res*10 + (int) curr-'0';
                // æ°å­è¶åºèå´
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
    
