package leetcode.leetcode103;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * @author Eivense
 * @date 2021/8/9 10:08 下午
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        boolean flag=true;
        while (!queue.isEmpty()) {
            // 当前行的节点个数
            int size = queue.size();

            List<Integer> temp = new ArrayList<>();
            while (size>0) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            result.add(level(temp,flag));
            // 反一反
            flag=!flag;
        }
        return result;
    }

    public List<Integer> level(List<Integer> list, boolean flag) {
        // 为true则翻转
        if(flag){
            List<Integer> temp = new ArrayList<>(list.size());
            for (int i = list.size()-1; i >= 0; i--) {
                temp.add(list.get(i));
            }
            return temp;
        }else{
            return list;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;

        Solution solution = new Solution();
        List<List<Integer>> result = solution.zigzagLevelOrder(root);
        System.out.println(result);

    }
}
