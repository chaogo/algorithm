//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 👍 1542 👎 0


package editor.cn;
    
public class RemoveNthNodeFromEndOfList {
    public static void main (String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
    }
// TIME: 15min

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 找到倒数第n个结点的前驱结点，即倒数第n+1个结点，
        // 第n个结点可能没有前驱结点
        // 链表不为空

        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode p = newHead; // 重要的不是从哪开始，重要的是差值
        ListNode q = newHead;

        for (int i = 0; i < n+1; ++i) { // 重要的不是从哪开始，重要的是差值
            p = p.next;
        }

        while (p != null) {
            p = p.next;
            q = q.next;
        }

        q.next = q.next.next;

        return newHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
