package leetcode.leetcode3;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author Eivense
 * @date 2021/9/25 9:16 下午
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {

        int result = 0;
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        // 左边界
        int right = -1;
        for (int i = 0; i < s.length(); i++) {
            // set里的去除
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while(right+1<s.length()&&!set.contains(s.charAt(right+1))){
                set.add(s.charAt(right+1));
                right++;
            }
            result = Math.max(result, right - i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring(" ");
    }
}
