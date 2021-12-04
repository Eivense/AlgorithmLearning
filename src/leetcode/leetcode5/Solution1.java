package leetcode.leetcode5;

/**
 * @author Eivense
 * @date 2021/9/25 2:46 下午
 */
public class Solution1 {

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i]=true;
        }

        int max=1;
        int beginIndex = 0;
        // 枚举字符串长度
        for (int i = 2; i <= s.length(); i++) {

            for (int left = 0; left < s.length()-i+1; left++) {
                int right = left + i - 1;

                if (s.charAt(left) == s.charAt(right)) {
                    if (i == 2) {
                        dp[left][right] = true;
                    }else{
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }else{
                    dp[left][right] = false;
                }

                if(dp[left][right]){
                    int length = right - left + 1;
                    if (length > max) {
                        max = length;
                        beginIndex = left;
                    }
                }
            }
        }
        return s.substring(beginIndex, beginIndex + max);

    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.longestPalindrome("bb");
    }
}
