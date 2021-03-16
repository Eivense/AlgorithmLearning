package leetcode.leetcode205;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * <p>
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] ss = new int[128];
        int[] tt = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int sCurrent = s.charAt(i);
            int tCurrent = t.charAt(i);
            if ((ss[sCurrent]!=0 &&ss[sCurrent]!= tCurrent) || (tt[tCurrent]!=0&&tt[tCurrent] != sCurrent)) {
                return false;
            }
            ss[sCurrent] = tCurrent;
            tt[tCurrent] = sCurrent;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isIsomorphic("ab", "ca");
    }
}
