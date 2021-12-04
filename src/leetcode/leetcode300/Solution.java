package leetcode.leetcode300;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @author Eivense
 * @date 2021/11/26 10:53 下午
 */
public class Solution {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
