package leetbook.array;

import javax.management.StandardEmitterMBean;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 *
 * @author Eivense
 * @date 2021/4/24 5:15 下午
 */
public class Solution3 {

    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0,nums.length);
    }

    public void rotate1(int[] nums, int k) {
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if (count == nums.length) {
                break;
            }
            int current = i;
            int prev = nums[i];
            do {
                // 计算新的位置
                int newPosition = (current + k) % nums.length;
                int temp = nums[newPosition];
                nums[newPosition] = prev;
                prev = temp;
                current = newPosition;
                count++;
            }while(i!=current);
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        solution.rotate1(new int[]{-1,-100,3,99}, 2);
    }
}
