package leetcode.leetcode151;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 151. 翻转字符串里的单词
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 *
 * @author Eivense
 * @date 2021/7/26 3:57 下午
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        Deque<Character> stack = new ArrayDeque<>();
        int index = s.length() - 1;
        while (index >= 0) {
            char c = s.charAt(index);
            if (c == ' ') {
                if (stack.isEmpty()) {
                    // ignore
                }else{
                    while (!stack.isEmpty()) {
                        stringBuilder.append(stack.pop());
                    }
                    // 字符间隔
                    stringBuilder.append(' ');
                }
            } else {
                stack.push(c);
            }
            index--;
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseWords("the sky is blue");
    }
}
