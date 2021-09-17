package leetcode.leetcode198;

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 *
 * @author Eivense
 * @date 2021/9/6 10:15 下午
 */
public class Solution {
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }else{
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            int max = Math.max(dp[0], dp[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
                max = Math.max(max, dp[i]);
            }

            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rob(new int[]{2, 1, 1, 2});
    }
}
