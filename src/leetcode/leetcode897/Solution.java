package leetcode.leetcode897;

import java.util.ArrayList;
import java.util.List;

/**
 * 897. 递增顺序查找树
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 *  
 *
 * 示例 ：
 *
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 * \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *
 * @author Eivense
 * @date 2021/3/30 10:16 下午
 */
public class Solution {
    List<TreeNode> result = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        if (!result.isEmpty()) {
            TreeNode head = result.get(0);
            TreeNode temp=head;
            head.left = null;
            for (int i = 1; i < result.size(); i++) {
                head.left = null;
                head.right = result.get(i);
                head = head.right;
            }
            return temp;
        }
        return null;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        result.add(root);
        dfs(root.right);
    }
}
