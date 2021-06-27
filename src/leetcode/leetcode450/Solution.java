package leetcode.leetcode450;

/**
 * 450. 删除二叉搜索树中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 *
 * @author Eivense
 * @date 2021/6/26 4:07 下午
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        int value = root.val;
        if (value == key) {
            TreeNode left= root.left;
            TreeNode right = root.right;
            // 当左右子树都为空时 直接删除该节点
            if (left == null && right == null) {
                root = null;
            } else if (left == null && right != null) {
                return right;
            } else if (right == null && left != null) {
                return left;
            }else{
                TreeNode max = getMax(left);
                root.val = max.val;
                // 再把max给删了
                root.left = deleteNode(left, max.val);
            }
        }else if(key>value){
            root.right = deleteNode(root.right, key);
        }
        // 小于则说明在左子树
        else{
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    // 获取左子树中最大的节点
    public TreeNode getMax(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
