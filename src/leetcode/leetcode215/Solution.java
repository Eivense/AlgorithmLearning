package leetcode.leetcode215;

/**
 * @author Eivense
 * @date 2021/9/26 10:08 下午
 */
public class Solution {

    int result = -1;

    public int findKthLargest(int[] nums, int k) {
        quicksort(nums, 0, nums.length - 1, k);
        if (result == -1) {
            return nums[nums.length - k];
        } else {
            return result;
        }
    }

    public void quicksort(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int target = nums[left];
        int index = left;
        for (int i = left + 1; i <= right; i++) {
            if (target >= nums[i]) {
                index++;
                swap(nums, i, index);
            }
        }
        swap(nums, left, index);
        if (index == nums.length - k) {
            result = nums[index];
            return;
        }
        quicksort(nums, left, index - 1, k);
        quicksort(nums, index + 1, right, k);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findKthLargest(new int[]{2, 1}, 2);
    }
}
