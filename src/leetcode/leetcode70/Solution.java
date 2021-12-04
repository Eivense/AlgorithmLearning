package leetcode.leetcode70;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author Eivense
 * @date 2021/10/10 10:00 下午
 */
public class Solution {

    public int climbStairs(int n) {

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        if (n < 3) {
            return dp[n];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
