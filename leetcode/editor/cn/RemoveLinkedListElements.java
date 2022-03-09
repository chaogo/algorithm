//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
// Related Topics 递归 链表 👍 689 👎 0


package editor.cn;
    
public class RemoveLinkedListElements {
    public static void main (String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
    }
// TIME: 40min

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
    public ListNode removeElements(ListNode head, int val) {
        // 结果链表
        ListNode newHead = new ListNode(){};
        ListNode tail = newHead;
        // 结点p在链表上游走，p.val！=val则将p连接至tail,否则就跳过
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            if (p.val != val) {
                p.next = null; // 作为tail结点，一定保证指向null; 或者说这里只连接一个结点，（打断），而不是一个链表，否则当链表以val结尾时会出bug
                tail.next = p;
                tail = tail.next;
            }
            p = tmp; // 由于p.next被重新赋值了，因此这里需要借助tmp,而不能p = p.next
        }

        return newHead.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
