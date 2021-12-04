package leetcode.leetcode450;

/**
 * @author Eivense
 * @date 2021/12/4 2:04 下午
 */
public class Solution1 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // 删除根节点
        if (root.val == key) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            // 左右子树都为空则直接删除
            if (left == null && right == null) {
                root= null;
            } else if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            }
            // 都不为空
            else{
                TreeNode max = findMax(left);
                root.val = max.val;
                // 再把max给删了
                root.left = deleteNode(left, max.val);
            }
        }
        // 在左子树
        else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        // 在右子树
        else{
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    // 找到该子树中最大的那个节点 即右子树
    public TreeNode findMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }


}
