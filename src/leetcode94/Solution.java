package leetcode94;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * 94. Binary Tree Inorder Traversal
 *
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 *
 * 中根遍历 左根右
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return inorder(root);
    }

//    public void inoreder(List<Integer> result, TreeNode root) {
//        if(root!=null){
//            inoreder(result,root.left);
//            result.add(root.val);
//            inoreder(result,root.right);
//        }
//    }

    public List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();

        while(root!=null||!stack.isEmpty()){

            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode node = stack.pop();
            result.add(node.val);
            root=node.right;
        }
        return result;
    }
}
