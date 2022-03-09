//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 👍 634 👎 0


package editor.cn;
import java.util.HashSet;

public class RemoveDuplicatesFromSortedList {
    public static void main (String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
    }
// TIME: 14min

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
    public ListNode deleteDuplicates(ListNode head) {
        // 思路 hashSet去重
        // BC 空链表
        // 与删除排序数组中的重复元素原理一致

        // 结果链表
        ListNode newHead = new ListNode(101){};
        ListNode tail = newHead;
//        // hashSet
//        HashSet<Integer> elements = new HashSet<>();
        // 遗漏了升序排列条件， 用不着hashSet
//        int cur = 101;  // 用tail既可以表示当前元素
        // 结点p遍历原链表，不重复的话就加入结果链表
        ListNode p = head;
        ListNode tmp;
        while (p != null) {
            tmp = p.next;
//            if (elements.add(p.val)) {
            if (p.val != tail.val) {
                p.next = null;
                tail.next = p;
                tail = p;
            }
            p = tmp;
        }
        return newHead.next;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
