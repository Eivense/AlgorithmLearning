package leetcode.leetcode437;

/**
 * 437. 路径总和 III
 * https://leetcode-cn.com/problems/path-sum-iii/
 *
 * @author Eivense
 * @date 2021/11/30 10:46 下午
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

    int total;
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return total;
    }

    public void dfs(TreeNode node,int targetSum) {
        if (node == null) {
            return;
        }
        total+=dfs1(node, targetSum);
        dfs(node.left, targetSum);
        dfs(node.right, targetSum);
    }
    public int dfs1(TreeNode node, int targetSum) {
        int result = 0;
        if (node == null) {
            return 0;
        }
        if (node.val == targetSum) {
            result++;
        }
        result += dfs1(node.left,targetSum - node.val);
        result += dfs1(node.right, targetSum - node.val);
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(10);
        TreeNode root1 = new TreeNode(5);
        TreeNode root2 = new TreeNode(-3);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(2);
        TreeNode root5 = new TreeNode(11);
        TreeNode root6 = new TreeNode(3);
        TreeNode root7 = new TreeNode(-2);
        TreeNode root8 = new TreeNode(1);

        root.left=root1;
        root.right = root2;

        root1.left=root3;
        root1.right = root4;
        root2.right=root5;

        root3.left=root6;
        root3.right = root7;

        root4.right = root8;

        solution.pathSum(root, 8);
    }
}
