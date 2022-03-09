//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 210 👎 0


package editor.cn;
    
public class ErChaSouSuoShuDeDiKdaJieDianLcof {
    public static void main (String[] args) {
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
    }
// TIME: 8min

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthLargest(TreeNode root, int k) {
        // 1 ≤ k ≤ 二叉搜索树元素个数
        int rightNodes = numNode(root.right);
        if (k == rightNodes + 1) return root.val;
        if (k <= rightNodes) {
            return kthLargest(root.right, k);
        } else {
            return kthLargest(root.left, k-rightNodes-1);
        }
    }

    private int numNode(TreeNode node) {
        if (node == null) return 0;
        return numNode(node.left) + numNode(node.right) + 1;
    }
}

//// 另 根据 右-根-左 中序遍历有序解体，但这样把前k个都求出来了，复杂度提高了
//class Solution {
//    int i = 0;
//    int targetId;
//    int target;
//    public int kthLargest(TreeNode root, int k) {
//        // 1 ≤ k ≤ 二叉搜索树元素个数
//        targetId = k;
//        inorder(root);
//        return target;
//    }
//
//    private void inorder(TreeNode node) {
//        if (node == null) return;
//        inorder(node.right);
//        i++;
//        if (i==targetId) target = node.val;
//        if (i >= targetId) return;
//        inorder(node.left);
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)

}
    
