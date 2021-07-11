package leetcode.leetcode35;

import javax.sound.midi.Soundbank;

/**
 * 35. 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * @author Eivense
 * @date 2021/7/11 9:42 下午
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if (target <= nums[left]) {
            return left;
        }else{
            return left + 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.searchInsert(new int[]{1}, 1);
    }
}
