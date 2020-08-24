package leetcode.leetcode101;


import java.util.ArrayList;
import java.util.List;

/**
 * 101. 对称二叉树
 *
 * 定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 */
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }


    private boolean check(TreeNode left,TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return (left.val == right.val) && check(left.left, right.right) && check(left.right, right.left);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(4);
        TreeNode r6 = new TreeNode(3);
        TreeNode r7 = new TreeNode(5);
        TreeNode r8 = new TreeNode(6);
        TreeNode r9 = new TreeNode(5);
        TreeNode r10 = new TreeNode(6);
        TreeNode r11 = new TreeNode(6);
        TreeNode r12 = new TreeNode(5);
        TreeNode r13 = new TreeNode(6);
        TreeNode r14 = new TreeNode(5);

        root.left=r1;
        root.right=r2;

        r1.left=r3;
        r1.right=r4;

        r2.left=r5;
        r2.right=r6;


        r3.left=r7;
        r3.right=r8;

        r4.left=r9;
        r4.right=r10;

        r5.left=r11;
        r5.right=r12;

        r6.left=r13;
        r6.right=r14;

        Solution solution = new Solution();
        solution.isSymmetric(root);

    }
}
