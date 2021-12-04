package leetcode.leetcode704;

/**
 * 704. 二分查找
 * https://leetcode-cn.com/problems/binary-search/
 *
 * @author Eivense
 * @date 2021/9/23 10:23 下午
 */
public class Solution {
    public int search(int[] nums, int target) {

        int left=0;
        int right = nums.length - 1;
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
        return -1;
    }
}
