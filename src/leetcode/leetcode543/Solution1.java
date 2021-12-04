package leetcode.leetcode543;

/**
 * @author Eivense
 * @date 2021/9/24 11:20 下午
 */
public class Solution1 {
    public int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        result = Math.max(result, left + right+1);
        return Math.max(left, right) + 1;
    }
}
