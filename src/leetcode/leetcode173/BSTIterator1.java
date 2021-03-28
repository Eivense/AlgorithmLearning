package leetcode.leetcode173;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Eivense
 * @date 2021/3/28 3:29 下午
 */
public class BSTIterator1 {
    private TreeNode current;
    private Deque<TreeNode> stack = new ArrayDeque<>();
    public BSTIterator1(TreeNode root) {
        current = root;
    }

    public int next() {
        while (current != null) {
            stack.push(current);
            // 中序
            current = current.left;
        }
        current = stack.pop();
        int val = current.val;
        current = current.right;
        return val;
    }

    public boolean hasNext() {
        return current != null || stack.isEmpty();
    }
}
