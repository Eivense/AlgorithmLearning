package leetcode.leetcode912;

import java.util.Arrays;

/**
 * 912. 排序数组
 * https://leetcode-cn.com/problems/sort-an-array/
 *
 * @author Eivense
 * @date 2021/9/23 11:49 下午
 */
public class Solution {

    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quicksort(int[] nums, int left, int right) {
        // 只有一个元素
        if (left >= right) {
            return;
        }
        // 选择第一个元素作为目标
        int target = nums[left];

        // target所应该在的位置
        int index=left;
        for (int i = index+1;i<=right;i++) {
            if (nums[i] <= target) {
                index++;
                swap(nums, i, index);
            }
        }
        swap(nums, left, index);
        quicksort(nums,left,index-1);
        quicksort(nums, index + 1, right);
    }

    /**
     * 交换下标
     */
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{5, 2, 3, 1};
        solution.sortArray(array);

    }
}
