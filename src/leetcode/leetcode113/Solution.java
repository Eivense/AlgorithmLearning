package leetcode.leetcode113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @author Eivense
 * @date 2021/11/29 11:04 下午
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new LinkedList<>(), root, targetSum);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> temp, TreeNode node, int target) {
        if (node == null) {
            return;
        }
        temp.add(node.val);
        // 是叶子节点
        if (node.left == null && node.right == null && target == node.val) {
            result.add(new ArrayList<>(temp));
        }
        // 加入当前节点
        dfs(result, temp, node.left, target-node.val);
        dfs(result, temp, node.right, target-node.val);
        if (!temp.isEmpty()) {
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(-2);
        TreeNode root2 = new TreeNode(-3);
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(-2);
        TreeNode root6 = new TreeNode(-1);

        root.left=root1;
        root.right=root2;

        root1.left=root3;
        root1.right=root4;

        root3.left=root6;
        root4.left=root5;

        solution.pathSum(root, 2);
    }
}
