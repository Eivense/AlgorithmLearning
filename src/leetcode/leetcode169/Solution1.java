package leetcode.leetcode169;

import java.util.Arrays;

/**
 * @author Eivense
 * @date 2021/9/25 1:31 下午
 */
public class Solution1 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length>>1];
    }
}
