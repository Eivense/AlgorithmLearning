package leetcode.leetcode718;

/**
 * @author Eivense
 * @date 2021/9/25 3:58 下午
 */
public class Solution1 {

    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n+1][m+1];

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.findLength(new int[]{1,2,3,2,1},new int[]{
            3, 2, 1, 4, 7});

    }
}
