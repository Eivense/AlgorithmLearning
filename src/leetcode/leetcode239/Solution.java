package leetcode.leetcode239;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Eivense
 * @date 2021/9/25 10:13 下午
 */
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 递增队列
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        // 枚举右边界
        for (int i = 0; i < nums.length; i++) {
            // 队尾的没有现在的大可以直接删掉
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            int left=i-k+1;
            // 删除超出区间的下标
            if (deque.peekFirst() < left) {
                deque.removeFirst();
            }

            // 形成窗口
            if (i + 1 >= k) {
                // 队首为最大元素
                result[left] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }
}
