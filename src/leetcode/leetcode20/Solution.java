package leetcode.leetcode20;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author Eivense
 * @date 2021/8/12 10:40 下午
 */
public class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (stack.isEmpty()||(current=='('||current=='['||current=='{')) {
                stack.push(s.charAt(i));
            }else{
                // 栈顶
                char top = stack.peek();
                if (top == '('&&current==')') {
                    stack.pop();
                } else if (top == '['&&current==']') {
                    stack.pop();
                } else if (top == '{' && current == '}') {
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
