package leetcode.leetcode32;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 32. 最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * @author Eivense
 * @date 2021/11/20 2:34 下午
 */
public class Solution {

    public int longestValidParentheses(String s) {

        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(new int[]{
                    c, i});
            } else {
                char top = (char)stack.peek()[0];
                if (c == ')' && top == '(') {
                    stack.pop();
                } else {
                    stack.push(new int[]{c, i});
                }
            }
        }
        if (stack.isEmpty()) {
            return s.length();
        }else{
            int right = s.length() - 1;
            int num = 0;
            int[] top = stack.pop();
            int range = right - top[1];
            num = Math.max(num, range);
            right = top[1];
            // 从尾开始
            while(!stack.isEmpty()) {
                int[] temp = stack.pop();
                range = right-temp[1]-1;
                num = Math.max(num, range);
                right = temp[1];
            }
            range = right;
            num = Math.max(num, range);
            return num;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(")()())()()("));
    }
}
