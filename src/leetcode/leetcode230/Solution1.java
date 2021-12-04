package leetcode.leetcode230;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eivense
 * @date 2021/9/25 1:19 下午
 */
public class Solution1 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, k);
        return list.get(k - 1);
    }

    // 中序遍历是升序的
    public void dfs(TreeNode node, List<Integer> list,int k) {
        if (node == null) {
            return;
        }
        if (list.size() == k) {
            return;
        }

        dfs(node.left,list,k);
        list.add(node.val);
        dfs(node.right,list,k);
    }
}
