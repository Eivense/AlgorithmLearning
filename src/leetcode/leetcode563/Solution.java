package leetcode.leetcode563;

/**
 * @author Eivense
 * @date 2021/3/22 10:55 下午
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
    int result = 0;

    public int findTilt(TreeNode root) {
        a(root);
        return result;
    }
    public int a(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = a(root.left);
        int right = a(root.right);
        result += Math.abs(left - right);

        return left+right+root.val;
    }
}
