package leetcode.leetcode337;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. House Robber III
 *
 *The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *
 * Input: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
public class Solution {
    public int rob(TreeNode root) {

        return dfs(root, new HashMap<>());
    }

    public int dfs(TreeNode node,Map<TreeNode,Integer> map){
        if(node==null)
            return 0;

        // 已经算过的节点从map里取
        if(map.containsKey(node))
            return map.get(node);

        int money=0;

        // 不包含左节点的当前最大值 value1 += rob(root.left.left) + rob(root.left.right);
        if(node.left!=null){
            money += dfs(node.left.left, map) + dfs(node.left.right, map);
        }

        // 不包含右节点的当前最大值 value1 += rob(root.right.left) + rob(root.right.right);
        if (node.right != null) {
            money += dfs(node.right.left, map) + dfs(node.right.right, map);
        }

        // value2 = rob(root.left) + rob(root.right);

        // 取value1和value2之间的最大值
        money = Math.max(money + node.val,dfs(node.left, map) + dfs(node.right, map));

        map.put(node, money);

        return money;
    }
}
