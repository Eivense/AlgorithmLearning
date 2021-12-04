package leetcode.leetcode31;

/**
 * 31. 下一个排列
 * https://leetcode-cn.com/problems/next-permutation/
 *
 * @author Eivense
 * @date 2021/10/1 2:20 下午
 */
public class Solution {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 从后往前寻找递增
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 如果i==-1 则说明原数组是个递减 直接reverse全部
        if (i >= 0) {
            // 从后往前找到第一个大于nums[i]的数
            int j = nums.length - 1;
            while (j>=0&&nums[i] >= nums[j]) {
                j--;
            }
            // 交换i和j
            swap(nums, i, j);
        }
        // 从i+1到数据组尾倒置
        reverse(nums, i+1, nums.length - 1);
    }

    /**
     * 交换i j
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 倒置start到end
     */
    public void reverse(int[] nums, int start, int end) {
        int left = start, right = end;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
