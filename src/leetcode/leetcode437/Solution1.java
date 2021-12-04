package leetcode.leetcode437;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eivense
 * @date 2021/12/1 10:38 下午
 */
public class Solution1 {

    int result;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        dfs(map, root, 0, targetSum);
        return result;
    }

    public void dfs(Map<Integer, Integer> map, TreeNode node,int current, int targetSum) {
        if (node == null) {
            return;
        }

        current += node.val;

        // 到当前点 前缀和差为targetSum的点的数量
        result += map.getOrDefault(current - targetSum, 0);
        map.put(current, map.getOrDefault(current, 0) + 1);

        dfs(map,node.left,current, targetSum);
        dfs(map, node.right, current, targetSum);

        // 回溯 因为其他点不在同一路径上
        map.put(current, map.getOrDefault(current, 0) - 1);
    }
}
