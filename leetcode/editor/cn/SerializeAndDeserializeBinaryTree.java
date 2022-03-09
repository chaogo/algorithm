//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
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
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 10⁴] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 725 👎 0


package editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public static void main (String[] args) {
//        Solution solution = new SerializeAndDeserializeBinaryTree().new Solution();
    }
// TIME:

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// BFS
public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null");
            } else {
//                sb.append(String.valueOf(node.val));
                sb.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            sb.append(',');
        }
//        System.out.println(sb.toString());
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] strArray = data.split(",");
        if (strArray[0].equals("null")) return null; // 字符串的比较最好还是用equals
        TreeNode root = new TreeNode(Integer.parseInt(strArray[0]));
        if (strArray.length == 1) return root;

        List<TreeNode> prevLayer = new ArrayList<>();
        prevLayer.add(root);
        List<TreeNode> curLayer = new ArrayList<>();
        int i = 1;
        while (i < strArray.length) {
            for (TreeNode node : prevLayer) {
                if (!strArray[i].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(strArray[i]));
                    curLayer.add(node.left);
                }
                i++;

                if (!strArray[i].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(strArray[i]));
                    curLayer.add(node.right);
                }
                i++;
            }
            prevLayer = curLayer;
            curLayer = new ArrayList<>();
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
    
