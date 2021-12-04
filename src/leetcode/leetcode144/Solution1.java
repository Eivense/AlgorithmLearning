package leetcode.leetcode144;

import java.util.*;

/**
 * @author Eivense
 * @date 2021/10/12 11:43 下午
 */
public class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        TreeNode node = root;
        while (!queue.isEmpty()||node!=null) {
            while (node != null) {
                result.add(node.val);
                queue.add(node);
                node = node.left;
            }
            node = queue.pop();
            node = node.right;
        }

        return result;
    }
}
