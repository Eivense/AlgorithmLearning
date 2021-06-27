package leetbook.array;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 *
 * @author Eivense
 * @date 2021/4/24 4:29 下午
 */
public class Solution1 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int previous = 0;
        for (int i=1;i<nums.length;i++) {
            if (nums[previous] != nums[i]) {
                nums[++previous] = nums[i];
            }
        }
        return previous;
    }
}
