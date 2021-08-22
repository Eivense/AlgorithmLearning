package leetcode.leetcode1822;

/**
 * 1822. 数组元素积的符号
 * https://leetcode-cn.com/problems/sign-of-the-product-of-an-array/
 *
 * @author Eivense
 * @date 2021/8/16 10:47 下午
 */
public class Solution {
    public int arraySign(int[] nums) {
        int value = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            }
            if (nums[i] <0) {
                value = value * -1;
            }
        }
        return value > 0 ? 1 : -1;
    }
}
