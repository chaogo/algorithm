//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 959 👎 0


package editor.cn;
    
public class FlattenBinaryTreeToLinkedList {
    public static void main (String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
    }
// TIME: 20min

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private TreeNode tail = new TreeNode();
    public void flatten(TreeNode root) {
        if (root==null) return;
        // 在连接后序结点过程和将root.left置为null的过程中，left和right结点都会丢失，因此暂存
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        tail.right = root;
        tail = tail.right;
        flatten(left);
        flatten(right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
