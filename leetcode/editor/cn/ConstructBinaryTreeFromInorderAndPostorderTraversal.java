//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 606 👎 0


package editor.cn;
    
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main (String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
    }
// TIME: 15min

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int size = inorder.length;
        return myBuildTree(inorder, 0, size-1, postorder, 0, size-1);
    }

    private TreeNode myBuildTree(int[] in, int i, int j, int[] post, int p, int q) {
//        if (i==j || p==q) return new TreeNode(in[i]);
        if (i>j || p > q) return null;

        int rootVal = post[q];
        TreeNode root = new TreeNode(rootVal);

        int r = i;
        while (in[r] != rootVal) r++;

        root.left = myBuildTree(in, i, r-1, post, p, p+(r-1-i));
        root.right = myBuildTree(in, r+1, j, post, p+r-i, q-1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
