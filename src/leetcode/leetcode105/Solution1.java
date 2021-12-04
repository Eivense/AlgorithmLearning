package leetcode.leetcode105;

/**
 * @author Eivense
 * @date 2021/9/23 12:34 上午
 */
public class Solution1 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int preOrderStart, int preOrderEnd, int inOrderStart, int inOrderEnd) {
        if (preOrderStart > preOrderEnd) {
            return null;
        }
        // 先根的第一个即为根节点
        int rootVal = preorder[preOrderStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = 0;
        // 找到根节点位置
        for (int i = inOrderStart; i <= inOrderEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        // 左子树节点数量
        int leftNum = rootIndex - inOrderStart;

        TreeNode left = dfs(preorder, inorder, preOrderStart + 1, preOrderStart + leftNum, inOrderStart, rootIndex - 1);
        TreeNode right = dfs(preorder, inorder, preOrderStart + leftNum +1, preOrderEnd,  rootIndex+ 1, inOrderEnd);
        root.left = left;
        root.right = right;
        return root;
    }
}
