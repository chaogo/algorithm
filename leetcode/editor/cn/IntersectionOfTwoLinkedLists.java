//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。 
//
// 图示两个链表在节点 c1 开始相交： 
//
// 
//
// 题目数据 保证 整个链式结构中不存在环。 
//
// 注意，函数返回结果后，链表必须 保持其原始结构 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, 
//skipB = 3
//输出：Intersected at '8'
//解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
//在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 
//1
//输出：Intersected at '2'
//解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
//在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
//由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//这两个链表不相交，因此返回 null 。
// 
//
// 
//
// 提示： 
//
// 
// listA 中节点数目为 m 
// listB 中节点数目为 n 
// 0 <= m, n <= 3 * 10⁴ 
// 1 <= Node.val <= 10⁵ 
// 0 <= skipA <= m 
// 0 <= skipB <= n 
// 如果 listA 和 listB 没有交点，intersectVal 为 0 
// 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1] 
// 
//
// 
//
// 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？ 
// Related Topics 哈希表 链表 双指针 👍 1337 👎 0


package editor.cn;

import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {
    public static void main (String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
    }
// TIME: 6min

//leetcode submit region begin(Prohibit modification and deletion)
//public class Solution {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        // O(n), O(1)
//        // 链表可能为空；
//        // 双指针，依次向后移动，当一个指针到头了就指向另一个链表的头部，（走短路的人被惩罚走完后去走长路，走长路的人接下里奖励走短路）
//        // 第一轮之后差距被抹平: 长链表a+c,短链表b+c，当两指针第二次经过相交结点时，一定是同时到达的，因为 a+c+b == b+c+a
//
//        if (headA == null || headB == null) return null;
//        ListNode you = headA;
//        ListNode she = headB;
//
//        // 要考虑到没有交点的情况, 否则会陷入死循环，第二次遇到null时终止循环返回null；
//        // 这里一同考虑了，当没有交点时，他们各自扫一遍会在都为null时退出循环
//        while (you != she) {
//            you = (you == null) ? headB : you.next;
//            she = (she == null) ? headA : she.next;
//        }
//
//        // 也可以先遍历得到两链表的长度，让长的先走差值步：更通用的解法
//
//        return you;
//    }
//}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 链表可能为空；、
        // 哈希表； 交点处结点地址同
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = headA;
        while(p!=null) {
            set.add(p);
            p = p.next;
        }

        ListNode q = headB;
        while(q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = q.next;
        }

        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
