//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1574 👎 0


package editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main (String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        char ch = 0;
        System.out.println(ch);
    }
// TIME: 18min

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<String> res = new ArrayList<>();
    private Map<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        // 可能为空
        if (digits.equals("")) return new ArrayList<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backTrack(digits, 0, new char[digits.length()]);
        return res;
    }
    
    private void backTrack(String digits, int k, char[] com) {
        if (k == digits.length()) {
            res.add(new String(com)); // take a snapshot
            return;
        }
        String choices = map.get(digits.charAt(k));
        for (int i = 0; i < choices.length(); i++) {
            com[k] = choices.charAt(i);
            backTrack(digits, k+1, com);
            com[k] = 0; // 每次都在com[k]上覆盖，可以不恢复
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
