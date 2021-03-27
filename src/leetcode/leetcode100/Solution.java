package leetcode.leetcode100;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * @author Eivense
 * @date 2021/3/26 11:08 下午
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }else if (p != null && q != null) {
            return p.val == q.val && isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
        }else{
            return false;
        }
    }
}
