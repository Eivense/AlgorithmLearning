package leetcode.leetcode242;

import java.util.HashMap;

/**
 * 242. 有效的字母异位词
 * <p>
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * @author Eivense
 * @date 2021/10/7 11:02 下午
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                int num = map.get(c);
                map.put(c, num + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                int num = map.get(c);
                if (num <= 0) {
                    return false;
                } else {

                    map.put(c, num - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
