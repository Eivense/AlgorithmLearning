package leetcode.leetcode316;


import java.util.*;

/**
 * 316. 去除重复字母
 *
 *
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 *
 */
public class Solution {

    public String removeDuplicateLetters(String s) {
        int[] nums = new int[26];
        Deque<Character> result = new ArrayDeque<>();

        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            nums[c-'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!result.contains(c)) {
                // 栈顶元素大于当前元素 且该元素后面还有
                while (!result.isEmpty()&&result.peek() > c && nums[result.peek() - 'a'] > 0) {
                    result.pop();
                }
                result.push(c);
                nums[c-'a']--;
            }else{
                nums[c-'a']--;
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!result.isEmpty()) {
            builder.append(result.removeLast());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String test = "bbcaac";
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicateLetters(test));

    }
}
