//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 👍 1057 👎 0


package editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main (String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
    }
// TIME:

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        if (root != null) queue.add(root);
//
//        while (!queue.isEmpty()) {
//            List<Integer> curLevel = new ArrayList<>();
//            int length = queue.size();
//            for (int i = 0; i < length; i++) {
//                TreeNode curNode = queue.poll();
//                curLevel.add(curNode.val);
//                if (curNode.left != null) queue.add(curNode.left);
//                if (curNode.right != null) queue.add(curNode.right);
//            }
//            res.add(curLevel);
//        }
//        return res;
//    }
//}

//// 另 层之间加null分割
//class Solution {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        if (root != null) {
//            queue.add(root);
//            queue.add(null);
//        }
//
//        List<Integer> curLevel = new ArrayList<>();
//        while (!queue.isEmpty()) {
//            TreeNode curNode = queue.poll();
//            if (curNode == null) {
//                queue.add(null); // 当前层结束，标记下一层
//                if (curLevel.size()==0) break;
//                res.add(curLevel);
//                curLevel = new ArrayList<>();
//                continue;
//            }
//            curLevel.add(curNode.val);
//            if (curNode.left != null) queue.add(curNode.left);
//            if (curNode.right != null) queue.add(curNode.right);
//        }
//        return res;
//    }
//}

// 用dfs实现层序遍历
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        dfs(node.left, level+1);
        dfs(node.right, level+1);
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
    
