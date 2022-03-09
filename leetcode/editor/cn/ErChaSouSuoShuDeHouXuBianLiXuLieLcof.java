//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 364 👎 0


package editor.cn;
    
public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main (String[] args) {
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        boolean res = true && solution.test(3);
        System.out.println(res);
    }
// TIME:

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private boolean test (int a) {
        System.out.println("hhh");
        return true;
    }

    public boolean verifyPostorder(int[] postorder) {
        // 根据后序遍历和二叉搜索树 来恢复树，同时判断
        return myVerifyPostorder(postorder, 0, postorder.length-1);
    }

    // 左子树的值 小于rootVal
    // 右子树的值 大于rootVal
    // 左子树是BST && 右子树是BST
    private boolean myVerifyPostorder(int[] post, int i, int j) {
        if (i >= j) return true;

        int rootVal = post[j];

        int m;
        for (m = i; m < j; m++) { // m最远可到达j
            if(post[m] > rootVal) break;
        }

        for (int k = m; k < j; k++) {
            if (post[k] < rootVal) return false;
        }

        return myVerifyPostorder(post, i, m-1) && myVerifyPostorder(post, m, j-1); // 分开写不会避免多余的递归
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
    
