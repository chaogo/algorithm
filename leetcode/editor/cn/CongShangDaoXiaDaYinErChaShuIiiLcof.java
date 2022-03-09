//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 146 👎 0


package editor.cn;

import java.util.*;

public class CongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main (String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
    }
// TIME:

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>>  res = new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        if (root != null) queue.add(root);
//        int level = 0;
//        while (!queue.isEmpty()) {
//            int levelLength = queue.size();
//            List<Integer> curLevel = new ArrayList<>();
//            if (level % 2 == 0) {
//                for (int i = 0; i < levelLength; i++) {
//                    TreeNode curNode = queue.poll();
//                    curLevel.add(curNode.val);
//                    if (curNode.left != null) queue.add(curNode.left);
//                    if (curNode.right != null) queue.add(curNode.right);
//                }
//            } else {
//                Stack<TreeNode> stack = new Stack<>();
//                for (int i = 0; i < levelLength; i++) {
//                    TreeNode curNode = queue.poll();
//                    stack.push(curNode);
//                    if (curNode.left != null) queue.add(curNode.left);
//                    if (curNode.right != null) queue.add(curNode.right);
//                }
//                while (!stack.isEmpty()) {
//                    curLevel.add(stack.pop().val);
//                }
//            }
//
//            res.add(curLevel);
//            level++;
//        }
//        return res;
//    }
//}

// 另 两个栈/双端队列
//class Solution {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        Stack<TreeNode> stack1 = new Stack<>();
//        Stack<TreeNode> stack2 = new Stack<>();
//
//        List<Integer> curLevel; // curLevel指向一直在变
//        if (root != null) stack1.add(root);
//        while (!stack1.isEmpty()){
//            curLevel = new ArrayList<>();
//            while (!stack1.isEmpty()) {
//                TreeNode curNode = stack1.pop();
//                curLevel.add(curNode.val); // 正常 从左到右的顺序
//                if (curNode.left != null) stack2.push(curNode.left);
//                if (curNode.right != null) stack2.push(curNode.right);
//            }
//            if (curLevel.size() != 0) res.add(curLevel); //res的当前最后一个指向curLevel当前指向的
//
//            curLevel = new ArrayList<>();
//            while (!stack2.isEmpty()) { // 由于栈 顺序已经反了
//                TreeNode curNode = stack2.pop();
//                curLevel.add(curNode.val);
//                if (curNode.right != null) stack1.push(curNode.right); //再反一遍，又正了
//                if (curNode.left != null) stack1.push(curNode.left);
//            }
//            if (curLevel.size() != 0) res.add(curLevel);
//        }
//        return res;
//    }
//}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> line = new LinkedList<>();
        if (root != null) {
            line.addLast(root);
            line.addLast(null);
        }

        List<Integer> curLevel;
        while (line.size() > 1) {
            curLevel = new ArrayList<>();
            while (line.peekFirst() != null) {
                TreeNode curNode = line.pollFirst();
                curLevel.add(curNode.val);
                if (curNode.left != null) line.addLast(curNode.left);
                if (curNode.right != null) line.addLast(curNode.right);
            }
            if (curLevel.size() != 0) res.add(curLevel);

            curLevel = new ArrayList<>();
            while (line.peekLast() != null) {
                TreeNode curNode = line.pollLast();
                curLevel.add(curNode.val);
                if (curNode.right != null) line.addFirst(curNode.right);
                if (curNode.left != null) line.addFirst(curNode.left);
            }
            if (curLevel.size() != 0) res.add(curLevel);
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
    
