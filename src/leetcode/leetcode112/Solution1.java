package leetcode.leetcode112;

/**
 * @author Eivense
 * @date 2021/10/11 9:34 下午
 */
public class Solution1 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    public boolean dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left==null&&root.right==null&root.val == targetSum) {
            return true;
        }
        boolean left = dfs(root.left, targetSum - root.val);
        boolean right = dfs(root.right, targetSum - root.val);
        return left || right;
    }
}
