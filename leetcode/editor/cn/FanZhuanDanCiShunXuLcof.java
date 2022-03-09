//English description is not available for the problem. Please switch to 
//Chinese. Related Topics 双指针 字符串 👍 123 👎 0


package editor.cn;

public class FanZhuanDanCiShunXuLcof {
    public static void main (String[] args) {
        Solution2 solution = new FanZhuanDanCiShunXuLcof().new Solution2();
        String res = solution.reverseWords("hello world !");
        System.out.println(res);
    }

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public String reverseWords(String s) {
//        /*
//        测试用例： null, "hello", "hello world!", "hello world !", "    ", "    hello world !    "
//        忽略所有空格，处理成单词栈-从后往前向StringBuilder中加
//         */
//        if (s==null) return null;
//        String[] words = s.strip().split(" "); //split时，regex前后仍是regex时，它会将前后处理成空的字符串
//        //自己实现split函数
////        List<String> words = new ArrayList<>();
////        int start = 0, q = 0;
////        while ( q < s.length()) {
////            if(!s.charAt(q).equals(" ")) {
////                start = q; // 只多记录一个当前字符串的初始位置
////                while(q < s.length()) {
////                    q++;
////                    if (s.charAt(q).equals(" ")) {
////                        break;
////                    }
////                }
////                words.add(s.substring(start, q));
////            }
////            q++;
////        }
//
//        StringBuilder revWords = new StringBuilder();
//
//
//        for (int j = words.length-1; j > 0; --j) {
//            if (!words[j].equals("")) {  //比较相等时，一定记得不要用==, !=,这样涉及到了地址，要用equals
//                revWords.append(words[j]);
//                revWords.append(" ");
//            }
//        }
//        revWords.append((words[0]));
//
//        return revWords.toString();
//    }
//}

// 另空间复杂度为O(1)的原地解法：把字符串反转封装成函数，两次反转
class Solution2 {
    public String reverseWords(String s) {
        // String类型是不可变的，需转换成char[]
        // 这里还是新申请了空间啊？--输入格式化和输出格式化的消耗不算在时间、空间复杂度中
        if (s == null) return null;
        char[] str = s.toCharArray();
        int n = trim(str);
        if (n == 0) return "";

        reverse(str, 0, n-1);
        int start = 0, end = 0;
        while (end < n) { // 经过trim处理后，这里的split过程的逻辑变得更加简单了，（可以跟Solution1中split实现做比较）
            if (str[end] == ' '){
                reverse(str, start, end-1);
                start = end + 1;
            } else if (end == n-1) {
                reverse(str, start, end);
            }
            end++;
        }

        return new String(str).substring(0, n);
    }

    // 处理前后及中间的多余的空格，原地
    private int trim(char[] str) {
        if (str==null || str.length==0) return 0;
        int i = 0, j = 0;
        int n = str.length;

        while (i < n) {
            if (str[i] == ' ' && (j==0 || str[j-1] == ' ')) { //第一个不能为空格；不能有连续两个空格
                i++;
                continue;
            }
            str[j++] = str[i++];
        }

        // 后面的空格忽略
        if (j != 0 && str[j-1] == ' ') return j-1;
        return j;
    }

    // 反转字符串
    private void reverse(char[] str, int start, int end) {
        char temp;
        while (start < end) {
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}