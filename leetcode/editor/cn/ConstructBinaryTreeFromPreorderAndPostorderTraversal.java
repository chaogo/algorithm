//返回与给定的前序和后序遍历匹配的任何二叉树。 
//
// pre 和 post 遍历中的值是不同的正整数。 
//
// 
//
// 示例： 
//
// 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pre.length == post.length <= 30 
// pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列 
// 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 193 👎 0


package editor.cn;
    
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main (String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
    }
// TIME:

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // 如果有多个答案，可以返回其中一个， (每层左右子树一边为空的情况)
        // 不为空
        // 前序遍历的第一个结点是根结点！
        int size = preorder.length;
        return myConstructFromPrePost(preorder, 0, size-1, postorder, 0, size-1);
    }

    private TreeNode myConstructFromPrePost(int[] pre, int i, int j, int[] post, int p, int q) {
        if (i == j || p == q) return new TreeNode(pre[i]);
        if (i > j || p > q) return null; // right分支可能会到这
        int rootVal = pre[i];
        TreeNode root = new TreeNode(rootVal);

        int r = p;
        while (post[r] != pre[i+1]) r++; // 左子树为空，pre[i+1]为右子树的根结点 的情况可以视为 左子树不为空pre[i+1]为根结点，右子树为空
        int leftSize = r-p+1;

        root.left = myConstructFromPrePost(pre, i+1, i+leftSize, post, p, r);
        root.right = myConstructFromPrePost(pre, i+leftSize+1, j, post, r+1, q-1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
