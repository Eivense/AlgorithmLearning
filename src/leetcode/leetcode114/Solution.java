package leetcode.leetcode114;

import java.util.ArrayList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 *
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
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

    public void flatten(TreeNode root) {
        while (root!= null) {
            if (root.left == null) {
                root = root.right;
            }else{
                TreeNode temp = root.left;
                while (temp.right != null) {
                    temp=temp.right;
                }
                temp.right = root.right;
                root.right=root.left;
                root.left = null;
                root = root.right;
            }
        }
    }


}
