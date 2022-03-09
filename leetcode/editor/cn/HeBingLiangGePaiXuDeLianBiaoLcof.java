//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 👍 159 👎 0


package editor.cn;
    
public class HeBingLiangGePaiXuDeLianBiaoLcof {
    public static void main (String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
        int[] l1 = new int[]{1,2,4};
        int[] l2 = new int[]{1,3,4};
        ListNode node1 = ListNode.toListNode(l1);
        ListNode node2 = ListNode.toListNode(l2);
        ListNode res = solution.mergeTwoLists(node1, node2);
        res.print();
    }
// TIME: 10min

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        // 双指针
//        // BC: 空链表，一个为空则返回另一个
//
//        // 结果链表
//        ListNode newHead = new ListNode(){};
//        ListNode tail = newHead;
//
//        // 双结点指针
//        ListNode p = l1;
//        ListNode q = l2;
//
//        while (p != null && q != null) {
//            if (p.val <= q.val) {
//                tail.next = p; // 有序，也没有删除操作，这里没有p.next = null这一步
//                tail = p;
//                p = p.next;
//            } else {
//                tail.next = q;
//                tail = q;
//                q = q.next;
//            }
//        }
//
//        if (p == null) {
//            tail.next = q;
//        }
//        if (q == null) {
//            tail.next = p;
//        }
//
//        return newHead.next;
//    }
//}

// 递归解法
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
