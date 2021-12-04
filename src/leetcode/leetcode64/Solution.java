package leetcode.leetcode64;

/**
 * 64. 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 *
 * @author Eivense
 * @date 2021/11/24 10:45 下午
 */
public class Solution {

    public int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                // 往下走
                int a = dp[i - 1][j] + grid[i][j];

                // 往右走
                int b = dp[i][j - 1] + grid[i][j];
                dp[i][j] = Math.min(a, b);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
