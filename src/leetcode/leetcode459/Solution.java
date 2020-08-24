package leetcode.leetcode459;

/**
 * 459. 重复的子字符串
 *
 *
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class Solution {

    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        for (int i = 1; i <= n/2; i++) {
            boolean result=false;
            if (n%i == 0) {
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) == s.charAt(j-i)) {
                        result = true;
                    }else{
                        result=false;
                        break;
                    }
                }
                if (result) {
                    return result;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedSubstringPattern("abab"));
    }
}
