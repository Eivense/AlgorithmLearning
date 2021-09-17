package leetcode.leetcode173;

import java.util.ArrayList;
import java.util.List;

/**
 * 173. 二叉搜索树迭代器
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 *
 * @author Eivense
 * @date 2021/8/25 10:05 下午
 */
public class BSTIterator2 {

    private List<TreeNode> list = new ArrayList<>();

    private int index;
    private int length;

    public BSTIterator2(TreeNode root) {
        index=0;
        dfs(root);
        length = list.size();
    }

    public int next() {
        return list.get(index++).val;
    }

    public boolean hasNext() {
        return index < length;
    }

    // 中序遍历 单调递增
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }
}
