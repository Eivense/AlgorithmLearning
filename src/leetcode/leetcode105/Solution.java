package leetcode.leetcode105;

/**
 *
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author Eivense
 * @date 2021/9/13 11:28 下午
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderright) {
        if (preorderLeft > preorderRight) {
            return null;
        }

        // preorder 第一个为根
        int rootVal = preorder[preorderLeft];
        TreeNode root = new TreeNode(rootVal);

        // inorder数组中找到当前的root
        int index = inorderLeft;
        for (int i = inorderLeft; i <= inorderright; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        // 左子树节点数量
        int leftTreeSize = index - inorderLeft;

        root.left = build(preorder, inorder,preorderLeft+1,preorderLeft+leftTreeSize , inorderLeft, index-1);
        root.right = build(preorder, inorder,preorderLeft+leftTreeSize+1,preorderRight , index+1, inorderright);

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }
}
