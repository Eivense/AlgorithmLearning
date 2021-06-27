package leetcode.leetcode111;

/**
 * 111. 二叉树的最小深度
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * @author Eivense
 * @date 2021/6/27 10:26 下午
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 叶子节点
        if (root.left == null&& root.right==null) {
            return 1;
        }
        // 左子树为空
        if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        }
        // 右子树为空
        else if (root.right != null && root.left == null) {
            return minDepth(root.right)+1;
        }else{
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
