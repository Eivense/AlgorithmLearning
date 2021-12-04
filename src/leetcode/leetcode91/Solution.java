package leetcode.leetcode91;

/**
 * 91. 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 *
 * @author Eivense
 * @date 2021/10/7 11:38 下午
 */
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        if (s.charAt(0) == '0') {
            return 0;
        }
        // dp[i] 以i为最后一个字符的字符串编码个数
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i - 1);
            int num = 0;
            // 单个数字组成字母
            if (c != '0') {
                num += dp[i - 1];
            }
            // 两个数字组成字母
            if (i > 1 && s.charAt(i - 2) != '0') {
                int a = s.charAt(i - 2) - '0';
                int b = c - '0';
                if (a * 10 + b <= 26) {
                    num += dp[i - 2];
                }
            }
            dp[i] = num;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numDecodings("226");
    }
}
