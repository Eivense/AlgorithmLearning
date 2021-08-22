package leetcode.leetcode236;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author Eivense
 * @date 2021/8/16 10:53 下午
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return dfs(root,p,q);

    }


    // 保存父节点对应的子节点
    public TreeNode dfs(TreeNode root,TreeNode p,TreeNode q) {
        // 找到p或者q或者到底了开始返回
        if (root == null || root == p || root == q) {
            return root;
        }

        // 左子树里找
        TreeNode left = dfs(root.left, p, q);
        // 右子树里找
        TreeNode right = dfs(root.right, p, q);

        // 左子树里没有
        if (left == null) {
            return right;
        }

        // 右子树里没有
        if (right == null) {
            return left;
        }

        // 左子树和右子树都不为空 说明p q在两侧 则root即为答案
        //
        return root;
    }
}
