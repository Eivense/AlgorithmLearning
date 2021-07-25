package leetcode.leetcode1448;

/**
 * 1448. 统计二叉树中好节点的数目
 * https://leetcode-cn.com/problems/count-good-nodes-in-binary-tree/
 *
 * @author Eivense
 * @date 2021/7/21 10:24 下午
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
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = root.val;
        int leftNum = dfs(root.left, max);
        int rightNum = dfs(root.right, max);
        // 根永远是好节点
        return leftNum + rightNum + 1;
    }

    public int dfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int value = root.val;
        int num = 0;
        if (value >= max) {
            num++;
            num += dfs(root.left, value);
            num += dfs(root.right, value);
        }else{
            num += dfs(root.left, max);
            num += dfs(root.right, max);
        }
        return num;
    }
}
