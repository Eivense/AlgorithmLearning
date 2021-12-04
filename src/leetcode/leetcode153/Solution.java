package leetcode.leetcode153;

/**
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * @author Eivense
 * @date 2021/11/11 11:22 下午
 */
public class Solution {
    // o(n)
    public int findMin(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            if (nums[index + 1] < nums[index]) {
                break;
            } else {
                index++;
            }
        }
        if (index == nums.length - 1) {
            return nums[0];
        } else {

            return nums[index+1];
        }
    }

    // 二分
    public int findMin1(int[] nums){
        int length = nums.length;

        int left=0;
        int right = length - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            if(nums[mid]<nums[right]){
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
