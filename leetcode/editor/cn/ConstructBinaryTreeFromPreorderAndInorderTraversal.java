//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1270 👎 0


package editor.cn;
    
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main (String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
    }
// TIME: 45min

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 不为空， 不重复
        int size = preorder.length;
        return myBuildTree(preorder, 0, size-1, inorder, 0, size-1);
    }

    private TreeNode myBuildTree(int[] preorder, int i, int j, int[] inorder, int p, int q) { // 都是闭区间
        if (i > j || p > q) return null;
        int rootVal = preorder[i];
        TreeNode root = new TreeNode(rootVal);

        int r = p; // root在inorder中的位置
        while (inorder[r] != rootVal) { r++; }
        int leftSize = r-p;

        root.left = myBuildTree(preorder, i+1, i+leftSize, inorder, p, r-1);
        root.right = myBuildTree(preorder, i+leftSize+1, j, inorder, r+1, q);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
