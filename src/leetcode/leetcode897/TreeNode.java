package leetcode.leetcode897;

/**
 * @author Eivense
 * @date 2021/3/30 10:16 下午
 */
public class TreeNode {
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
