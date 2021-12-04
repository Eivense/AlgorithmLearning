package leetcode.leetcode322;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 *
 * @author Eivense
 * @date 2021/10/9 11:19 下午
 */
public class Solution {


    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        return dfs(coins, amount, new int[amount+1]);
    }

    public int dfs(int[] coins, int amount, int[] count) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (count[amount] != 0) {
            return count[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            int temp = dfs(coins, amount - coin, count);
            if (temp >= 0 && temp < min) {
                min = temp + 1;
            }
        }
        count[amount] = (min == Integer.MAX_VALUE ? -1 : min);
        return count[amount];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.coinChange(new int[]{1, 2,5}, 11);
    }
}
