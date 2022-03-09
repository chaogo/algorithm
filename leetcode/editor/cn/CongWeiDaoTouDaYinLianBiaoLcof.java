//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 187 👎 0


package editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main (String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        int[] test = new int[]{1,3,2};
        ListNode head = ListNode.toListNode(test);
        int[] res = solution.reversePrint(head);
        System.out.println(res[0]);
    }
// TIME: 17

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> array = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        reverse(head);
        int[] res = new int[array.size()];
        int i = 0;
        for (int k : array) {
            res[i++] = k;
        }
        return res;
    }

    private void reverse(ListNode node) {
        if (node == null) return;
        reverse(node.next);
        array.add(node.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
