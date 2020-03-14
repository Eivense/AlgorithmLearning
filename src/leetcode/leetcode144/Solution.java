package leetcode.leetcode144;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 144. Binary Tree Preorder Traversal
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,2,3]
 *
 * 先根遍历 根左右
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return preorder(root);
    }

//    public void preorder(List<Integer> result, TreeNode root) {
//        if(root!=null){
//            result.add(root.val);
//            preorder(result,root.left);
//            preorder(result,root.right);
//        }
//    }

    // 非递归
    public List<Integer> preorder(TreeNode root){
        List<Integer> result = new ArrayList<>();

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        while (root!=null||!stack.isEmpty()) {
           while(root!=null){
               result.add(root.val);
               stack.push(root);
               root=root.left;
           }
           TreeNode node=stack.pop();
           root=node.right;
        }
        return result;
    }
}
