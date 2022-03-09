//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 252 👎 0


package editor.cn;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
    public static void main (String[] args) {
        Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
    }
// TIME:

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> paths = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int pathSum = 0;
    private int target;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        // 可能为空
        this.target = target;
        if (root != null) {
            dfs(root);
        }
        return paths;
    }

    private void dfs(TreeNode root) { // dfs的栈就是path; 先序遍历的同时顺便计算路径和
        path.add(root.val);
        pathSum += root.val;
        if (root.left == null && root.right == null) { // leaf node
            if (pathSum == target) {
                List<Integer> snapShot = new ArrayList<>(path);
                paths.add(snapShot);
            }
        }
        if (root.left != null) {
            dfs(root.left);
            path.remove(path.size()-1);
            pathSum -= root.left.val;
        }
        if (root.right != null) {
            dfs(root.right);
            path.remove(path.size()-1);
            pathSum -= root.right.val;
        }


    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
    
