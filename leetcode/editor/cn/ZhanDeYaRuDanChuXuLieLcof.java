//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈
//的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。 
//
// 
//
// 示例 1： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true
//解释：我们可以按以下顺序执行：
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// 示例 2： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//输出：false
//解释：1 不能在 2 之前弹出。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= pushed.length == popped.length <= 1000 
// 0 <= pushed[i], popped[i] < 1000 
// pushed 是 popped 的排列。 
// 
//
// 注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/ 
// Related Topics 栈 数组 模拟 👍 232 👎 0


package editor.cn;

import java.util.HashSet;
import java.util.Stack;

public class ZhanDeYaRuDanChuXuLieLcof {
    public static void main (String[] args) {
        Solution solution = new ZhanDeYaRuDanChuXuLieLcof().new Solution();

    }
// TIME: 50min

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        // push操作的顺序已经确定，在其中放pop,看是否能依次弹出目标弹出序列
//        // 当前pop的数字 之前的数字 除已经pop出的外 顺序已经确定，不可更改
//        // 将当前元素cur前面的元素放入栈中，接下来的元素只有可能是栈顶元素或在cur后面
//        // 即模拟这个栈， 记录还没出栈的元素
//        // 同时用一个哈希set,记录处理过的元素
//        // 都可能为空
//
//        Stack<Integer> stack = new Stack<>();
//        HashSet<Integer> set = new HashSet<>();
//
//        int n = pushed.length;
//        int j = 0;
//        int cur;
//        for (int i = 0; i < n; i++) {
//            cur = popped[i];
//            if (set.add(cur)) {
//                while (j < n && pushed[j] != cur) {
//                    stack.push(pushed[j]);
//                    set.add(pushed[j]);
//                    j++;
//                }
//                j++; // 在pushed中找到了cur,cur也已经处理了，因此需要再移动一位
//            } else if (cur != stack.pop()){ // 已经处理过
//                return false;
//            }
//        }
//
//        return true;

//        // 模拟这个栈
//        // 当前元素一定是在栈顶处理，否则一定在栈顶元素所在pushed中的位置之后处理，如果"之后"也没找到则false
//        // 替代hashSet的另一种方式：用j遍历一遍没找到代替
//
//        Stack<Integer> stack = new Stack<>();
//
//        int n = pushed.length;
//        int j = 0;
//        int cur;
//        for (int i = 0; i < n; ++i) {
//            cur = popped[i];
//            if (stack.isEmpty() || cur != stack.peek()) {
//                while (j < n && pushed[j] != cur) {
//                    stack.push(pushed[j]);
//                    j++;
//                }
//                if (j == n) return false; // 找到头都没找到，说明被压倒栈底了，不可能现在被pop出来
//                j++;
//            } else {
//                stack.pop();
//            }
//        }
//        return true;
//    }

    // 模拟这个栈
    // 也可以以pushed为主要考察对象

    Stack<Integer> stack = new Stack<>();

    int n = pushed.length;
    int j = 0;
    int cur;
    for (int i = 0; i < n; ++i) {
        cur = pushed[i];
        stack.push(cur);
        while (!stack.isEmpty() && stack.peek() == popped[j]) {
            stack.pop();
            j++;
        }
    }
    return stack.isEmpty();
}
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
