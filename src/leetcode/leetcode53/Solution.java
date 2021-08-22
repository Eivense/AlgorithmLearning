package leetcode.leetcode53;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @author Eivense
 * @date 2021/8/20 10:40 下午
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxSubArray(new int[]{4,6,-2,5,6});
    }
}
