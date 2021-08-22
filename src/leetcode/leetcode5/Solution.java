package leetcode.leetcode5;

/**
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author Eivense
 * @date 2021/7/31 2:35 下午
 */
public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        // i-j是否为回文串
        boolean[][] dp = new boolean[length][length];

        // i-i 即长度为1的字符串都是回文串
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        int beginIndex = 0;
        int maxLength = 1;
        // 从长度为2的
        for (int i = 2; i <= length; i++) {
            // 左边界
            for (int left = 0; left< length; left++) {
                // 右边界
                int right = left + i - 1;
                if (right > length - 1) {
                    break;
                }
                if (s.charAt(left) != s.charAt(right)) {
                    dp[left][right] = false;
                }else{
                    if (i == 2) {
                        dp[left][right] = true;
                    }else{
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }
                // 如果为回文串 则计算长度
                if (dp[left][right]) {
                    int tempLength = right - left + 1;
                    if (tempLength > maxLength) {
                        maxLength = tempLength;
                        beginIndex = left;
                    }
                }
            }
        }
        return s.substring(beginIndex, beginIndex + maxLength);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestPalindrome("a");
    }
}
