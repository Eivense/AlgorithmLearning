package leetcode.leetcode129;

import java.util.Map;

/**
 * @author Eivense
 * @date 2021/12/1 11:09 下午
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
     int result=0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode node,int current){
        if (node == null) {
            return;
        }
        current =current*10+node.val;

        if (node.left == null && node.right == null) {
            result += current;
        }

        dfs(node.left, current);
        dfs(node.right, current);
    }
}
