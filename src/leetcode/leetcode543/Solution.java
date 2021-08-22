package leetcode.leetcode543;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 *
 * @author Eivense
 * @date 2021/8/19 11:52 下午
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
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return result;
    }

    // 求某个节点的深度
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        // 经过当前节点的最大路径
        int path=Math.max(result,left+right);
        // 返回深度
        return Math.max(left,right)+1;
    }
}
