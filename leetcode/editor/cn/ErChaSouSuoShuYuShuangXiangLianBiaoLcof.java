//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。 
//
// 
//
// 为了让您更好地理解问题，以下面的二叉搜索树为例： 
//
// 
//
// 
//
// 
//
// 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是
//第一个节点。 
//
// 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。 
//
// 
//
// 
//
// 
//
// 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。 
//
// 
//
// 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
//to-sorted-doubly-linked-list/ 
//
// 注意：此题对比原题有改动。 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 链表 二叉树 双向链表 👍 336 👎 0


package editor.cn;
    
public class ErChaSouSuoShuYuShuangXiangLianBiaoLcof {
    public static void main (String[] args) {
        Solution solution = new ErChaSouSuoShuYuShuangXiangLianBiaoLcof().new Solution();
    }
// TIME: 15min

//leetcode submit region begin(Prohibit modification and deletion)

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class Solution {
    private Node newHead = new Node();
    private Node tail = newHead;

    public Node treeToDoublyList(Node root) {
        // 树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继
        dfs(root);
        if (newHead.right == null) return null; // 空树
        Node head = newHead.right;
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void dfs(Node root) {
        if (root==null) return;
        dfs(root.left);
        root.left = tail;
        tail.right = root;
        tail = tail.right;
        dfs(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    
