package leetcode.leetcode53;

/**
 * @author Eivense
 * @date 2021/9/26 9:37 下午
 */
public class Solution1 {

    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];

        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
