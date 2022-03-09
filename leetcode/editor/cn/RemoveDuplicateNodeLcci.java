//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 哈希表 链表 双指针 👍 125 👎 0


package editor.cn;

import java.util.HashSet;

public class RemoveDuplicateNodeLcci {
    public static void main (String[] args) {
        Solution solution = new RemoveDuplicateNodeLcci().new Solution();
    }
// TIME: 16min

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
    public ListNode removeDuplicateNodes(ListNode head) {
        // 不使用临时缓冲区
        // 可能为空
        // 哈希表
        HashSet<Integer> set = new HashSet<>();
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        ListNode q = head;
        while (q != null) {
            if (set.add(q.val)) {
                tail.next = q;
                tail = tail.next;
            }
            q = q.next;
        }
        tail.next = null; // 链表结束记得断开

        return newHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
