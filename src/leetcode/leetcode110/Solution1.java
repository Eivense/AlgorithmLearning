package leetcode.leetcode110;

/**
 * @author Eivense
 * @date 2021/10/10 10:50 下午
 */
public class Solution1 {

    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return result;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right)>1) {
            result = false;
        }
        return Math.max(left, right) + 1;
    }

}
