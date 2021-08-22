package leetcode.leetcode662;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 662. 二叉树最大宽度
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 *
 * @author Eivense
 * @date 2021/8/22 6:54 下午
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Node{
    TreeNode treeNode;

    int position;

    public Node(TreeNode treeNode, int position) {
        this.treeNode = treeNode;
        this.position = position;
    }
}

public class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        int result = 0;

        Queue<Node> queue = new ArrayDeque<>();

        if (root != null) {
            queue.add(new Node(root, 0));
        }

        while (!queue.isEmpty()) {
            int width = queue.size();
            int left=0;
            int right=0;
            Node leftNode=queue.peek();
            left=leftNode.position;
            while (width>0) {
                Node node = queue.poll();
                // 最右节点
                if (width == 1) {
                    right = node.position;
                }
                TreeNode treeNode = node.treeNode;
                if (treeNode.left != null) {
                    queue.add(new Node(treeNode.left,node.position*2));
                }
                if (treeNode.right != null) {
                    queue.add(new Node(treeNode.right, node.position * 2 + 1));
                }
                width--;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root= new TreeNode(1);
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(5);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(9);

        root.left=root1;
        root.right=root2;
        root1.left=root3;
        root1.right=root4;
        root2.right = root5;

        solution.widthOfBinaryTree(root);

    }
}
