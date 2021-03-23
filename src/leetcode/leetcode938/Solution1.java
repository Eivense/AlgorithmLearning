package leetcode.leetcode938;

/**
 * @author Eivense
 * @date 2021/3/21 11:08 下午
 */


public class Solution1 {
    private int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        range(root,low,high);
        return result;
    }

    public void range(TreeNode treeNode, int low, int high) {
        if (treeNode == null) {
            return ;
        }
        if (treeNode.val >= low && treeNode.val <= high) {
            result += treeNode.val;
        }

        range(treeNode.left, low, high);
        range(treeNode.right, low, high);
    }
}
