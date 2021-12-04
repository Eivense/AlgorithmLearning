package leetcode.leetcode121;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @author Eivense
 * @date 2021/10/8 10:15 下午
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i];
                index = i;
            }
            // 只能在后一天卖出
            if (index < i) {
                int temp = prices[i] - min;
                max = Math.max(temp, max);
            }
        }
        return max;
    }

    public int maxProfit1(int[] prices){
        int n=prices.length;

        // dp[i][0] 表示持有股票  dp[i][1]表示没有持有股票
        // 最大利润
        int[][] dp = new int[n][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            // 持股
            dp[i][0] = Math.max(dp[i - 1][0],-prices[i]);
            // 不持股 即卖掉
            dp[i][1] = Math.max(dp[i-1][1],dp[i - 1][0] + prices[i]);
        }

        return dp[n - 1][1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxProfit1(new int[]{7,1,5,3,6,4});
    }
}
