package leetcode.leetcode2000;

/**
 * 2000. 反转单词前缀
 * https://leetcode-cn.com/problems/reverse-prefix-of-word/
 *
 * @author Eivense
 * @date 2021/9/20 11:11 下午
 */
public class Solution {
    public String reversePrefix(String word, char ch) {

        int start = word.indexOf(ch);
        String subString = word.substring(0, start+1);
        StringBuilder builder = new StringBuilder();
        for (int i = subString.length() - 1; i >= 0; i--) {
            builder.append(subString.charAt(i));
        }
        builder.append(word.substring(start+1));
        return builder.toString();
    }
}
