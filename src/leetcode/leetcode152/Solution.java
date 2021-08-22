package leetcode.leetcode152;

import java.util.EnumMap;

/**
 *
 * 152. 乘积最大子数组
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 *
 * @author Eivense
 * @date 2021/8/20 11:19 下午
 */
public class Solution {

    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int result = dpMin[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            dpMax[i] = Math.max(dpMax[i - 1] * num,Math.max(num,dpMin[i - 1] * num));
            dpMin[i] = Math.min(dpMax[i - 1] * num, Math.min(num, dpMin[i - 1] * num));
        }

        for (int i = 0; i < dpMax.length; i++) {
            result = Math.max(result, dpMax[i]);
        }
        return result;
    }
}
