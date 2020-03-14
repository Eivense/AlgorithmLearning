package leetcode.leetcode145;

import java.util.*;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [3,2,1]
 *
 * 后根遍历 左右根
 *
 */


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        return postorder(root);
    }

//    public void postorder(List<Integer> result,TreeNode root){
//        if(root!=null){
//            postorder(result,root.left);
//            postorder(result,root.right);
//            result.add(root.val);
//        }
//    }

    // 非递归
    public List<Integer> postorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();

        TreeNode node=root;
        while(node!=null){
            stack.push(node);
            node = node.left;
        }

        while(!stack.isEmpty()){
            node = stack.peek();
            if(visited.contains(node)){
                stack.pop();
                result.add(node.val);
                continue;
            }else{
                visited.add(node);
            }
            node=node.right;
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
        }
        return result;
    }

}
