package leetcode.leetcode438;

import java.util.*;

/**
 * 438. 找到字符串中所有字母异位词
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 *
 * @author Eivense
 * @date 2021/11/28 9:27 下午
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int[] ss = new int[26];
        int[] pp = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pp[p.charAt(i) - 'a']++;
            ss[s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(ss,pp)){
            result.add(0);
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            --ss[s.charAt(i) - 'a'];
            ++ss[s.charAt(i + p.length()) - 'a'];
            if (Arrays.equals(ss, pp)) {
                result.add(i);
            }
        }
        return result;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findAnagrams("abab", "ab");
    }
}
