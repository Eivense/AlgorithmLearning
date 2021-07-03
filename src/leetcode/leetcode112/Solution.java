package leetcode.leetcode112;

/**
 * 112. 路径总和
 *
 * https://leetcode-cn.com/problems/path-sum/
 *
 * @author Eivense
 * @date 2021/6/28 10:40 下午
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int value = root.val;
        if (root.left == null && root.right == null) {
            return targetSum == value;
        }
        return hasPathSum(root.left, targetSum-value) || hasPathSum(root.right, targetSum-value);
    }
}
