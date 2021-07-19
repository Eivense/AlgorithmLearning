package leetcode.leetcode1;

import java.util.*;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author Eivense
 * @date 2021/7/17 3:06 下午
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{
                    i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
