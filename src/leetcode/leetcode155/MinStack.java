package leetcode.leetcode155;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 155. 最小栈
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 */
public class MinStack {

    private Stack<int[]> stack1;

    public MinStack() {
        stack1 = new Stack<>();
    }

    public void push(int val) {
        if (stack1.isEmpty()) {
            stack1.push(new int[]{val, val});
        }else{
            stack1.push(new int[]{val, Math.min(val, stack1.peek()[1])});
        }
    }

    public void pop() {
        stack1.pop();
    }

    public int top() {
        return stack1.peek()[0];
    }

    public int getMin() {
        return stack1.peek()[1];
    }
}
