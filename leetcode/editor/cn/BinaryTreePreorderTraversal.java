//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,2,3]
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
//输入：root = [1]
//输出：[1]
//
//
// 示例 4：
//
//
//输入：root = [1,2]
//输出：[1,2]
//
//
// 示例 5：
//
//
//输入：root = [1,null,2]
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 深度优先搜索 二叉树 👍 662 👎 0

package editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public static void main (String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
    }
// TIME:

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return res;
    }

    private void preorder(TreeNode node) {
        if (node == null) return;
        res.add(node.val);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }
}

// 非递归， 手动模拟函数调用栈
//
//class Solution {
//    class SFrame {
//        int status;
//        TreeNode node;
//
//        SFrame(TreeNode node, int status) {
//            this.status = status;
//            this.node = node;
//        }
//    }
//
//    private List<Integer> res = new ArrayList<>();
//
//    public List<Integer> preorderTraversal(TreeNode root) {
//        Stack<SFrame> stack = new Stack<>();
//        if (root != null) stack.push(new SFrame(root, 1));
//        while (!stack.isEmpty()) {
//            SFrame curFrame = stack.peek();
//            if (curFrame.status == 1) {
//                res.add(curFrame.node.val);
//                curFrame.status = 2;
//                if (curFrame.node.left != null) {
//                    stack.push(new SFrame(curFrame.node.left, 1));
//                    continue;
//                }
//            }
//            if (curFrame.status == 2) {
//                curFrame.status = 3;
//                if (curFrame.node.right != null)
//                    stack.push(new SFrame(curFrame.node.right, 1));
//                continue;
//            }
//            if (curFrame.status == 3) {
//                stack.pop();
//            }
//        }
//        return res;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)

}


