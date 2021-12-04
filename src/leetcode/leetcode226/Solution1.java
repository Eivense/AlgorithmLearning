package leetcode.leetcode226;

/**
 * @author Eivense
 * @date 2021/10/12 11:53 下午
 */
public class Solution1 {
    public TreeNode invertTree(TreeNode root) {
        return reverse(root);
    }

    public TreeNode reverse(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = reverse(node.right);
        TreeNode right = reverse(node.left);
        node.left = left;
        node.right = right;
        return node;
    }
}
