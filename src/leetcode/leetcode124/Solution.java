package leetcode.leetcode124;

/**
 * 124. 二叉树中的最大路径和
 *
 *
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {

    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }


    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMax = Math.max(0, dfs(node.left));

        int rightMax = Math.max(0, dfs(node.right));

        // left+root+right 没有办法递归 直接记录值
        max = Math.max(max, node.val + leftMax + rightMax);

        return node.val + Math.max(leftMax, rightMax);
    }
}
