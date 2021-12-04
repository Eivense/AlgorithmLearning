package leetcode.leetcode14;

/**
 * 14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author Eivense
 * @date 2021/10/10 9:11 下午
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = prefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String prefix(String a, String b) {
        int length = Math.min(a.length(), b.length());
        int index = 0;
        while (index < length && a.charAt(index) == b.charAt(index)) {
            index++;
        }
        return a.substring(0, index);
    }
}
