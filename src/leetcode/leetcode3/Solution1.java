package leetcode.leetcode3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Eivense
 * @date 2021/10/11 11:06 下午
 */
public class Solution1 {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int right = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            // 窗口移动
            if (i > 0) {
                set.remove(s.charAt(i - 1));
            }
            while (right+1<s.length()&&!set.contains(s.charAt(right+1))) {
                set.add(s.charAt(right+1));
                right++;
            }
            max = Math.max(right - i + 1, max);
        }

        return max;
    }
}
