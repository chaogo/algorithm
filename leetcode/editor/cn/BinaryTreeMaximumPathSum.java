//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1259 👎 0


package editor.cn;
    
public class BinaryTreeMaximumPathSum {
    public static void main (String[] args) {
//        Solution solution = new BinaryTreeMaximumPathSum().new Solution();

    }
// TIME:

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    private int maxSum= Integer.MIN_VALUE;
//
//    public int maxPathSum(TreeNode root) {
//        // 不为空；
//        // 结点值有负数; 不一定包含根结点和叶子结点
//        dfs(root);
//        return maxSum;
//    }
//    private int dfs(TreeNode root) {
//        //root参与的单边的最大路径和
//        //最小子问题，三个结点
//        // if (root == null) , impossible to reach
//        int leftSum = 0, rightSum = 0;
//        if (root.left != null) { leftSum = dfs(root.left);}
//        if (root.right != null) { rightSum = dfs(root.right);}
//        int path = root.val + Math.max(Math.max(leftSum, 0), Math.max(rightSum,0)); // path只要一边
//        int sum = root.val + Math.max(leftSum, 0) + Math.max(rightSum,0); // 最大路径和要两边
//        maxSum = Math.max(maxSum, sum);
//        return path;
//    }
//}

class Solution {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        // node为顶的(单边）最大路径和， 连续但不一定走到底;
        // 过程中顺便更新以node为顶的最大路径和maxSum

        if (node == null) return 0;

        int leftSum = dfs(node.left);
        if (leftSum < 0) leftSum = 0; // 如果最大路径和为负数，则不选

        int rightSum = dfs(node.right);
        if (rightSum < 0) rightSum = 0;

        int path = Math.max(leftSum, rightSum) + node.val;

        // 顺便更新maxSum
        int sum = leftSum + rightSum + node.val; // node.val可能为负，但这里必须参与
        maxSum = Math.max(maxSum, sum);
        return path;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}