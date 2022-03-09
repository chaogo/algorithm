//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
//
// 注意：本题与主站 235 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-
//a-binary-search-tree/ 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 174 👎 0


package editor.cn;
    
public class ErChaSouSuoShuDeZuiJinGongGongZuXianLcof {
    public static void main (String[] args) {
        Solution solution = new ErChaSouSuoShuDeZuiJinGongGongZuXianLcof().new Solution();
    }
// TIME: 30min

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    private TreeNode lca = null;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        // BST的左子树都小于root.val，右子树都大于root.val
//        // 若p.val < root.val, p必然在root的左子树上
//        if (p.val < q.val) dfs(root, p, q);
//        else dfs(root, q, p);
//        return lca;
//    }
//
//    private void dfs(TreeNode root, TreeNode p, TreeNode q) { // p.val < q.val
//        if (p.val <= root.val && root.val <= q.val) { lca = root;}
//        if (root.val < p.val) { dfs(root.right, p, q); }
//        if (root.val > q.val) { dfs(root.left, p, q); }
//    }
//}

// 非递归实现
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode x = root;
        while (true) {
            if (p.val < x.val && q.val < x.val) x = x.left;
            else if (p.val > x.val && q.val > x.val) x = x.right;
            else return x;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
