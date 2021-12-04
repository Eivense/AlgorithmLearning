package leetcode.leetcode221;

/**
 * 221. 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 *
 * @author Eivense
 * @date 2021/10/2 8:52 下午
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length;
        int m = matrix[0].length;
        int result = 0;
        // 以dp[i][j] 为右下角的边长
        int[][] dp = new int[n][m];
        // 枚举左上角
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result * result;
    }
}
