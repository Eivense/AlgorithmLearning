package leetcode.leetcode99;

/**
 * 99. 恢复二叉搜索树
 *
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 *
 * @author Eivense
 * @date 2021/6/28 11:10 下午
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        int value = root.val;
        if (root.left != null) {
            TreeNode left = root.left;
            if (left.val > value) {
                root.val = left.val;
                left.val = value;
                return;
            } else{
                recoverTree(root.left);
            }
        }

        if (root.right != null) {
            TreeNode right = root.right;
            if (right.val < value) {
                root.val = right.val;
                right.val = value;
                return;
            }else{
                recoverTree(root.right);
            }
        }
    }
}
