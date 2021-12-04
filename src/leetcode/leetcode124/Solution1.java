package leetcode.leetcode124;

/**
 * @author Eivense
 * @date 2021/9/25 10:03 下午
 */
public class Solution1 {

    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        result = Math.max(result, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
