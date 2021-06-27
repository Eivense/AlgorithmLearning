package leetbook.array;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
 *
 * @author Eivense
 * @date 2021/4/24 4:58 下午
 */
public class Solution2 {
    // 贪心 局部最优解组成全局最优解
    public int maxProfit(int[] prices){
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            result += Math.max(0, prices[i] - prices[i-1]);
        }

        return result;
    }
}
