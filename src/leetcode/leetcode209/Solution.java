package leetcode.leetcode209;

/**
 * 209. Minimum Size Subarray Sum
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 *
 *
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {

        // 左右指针
        int left=0;int right=0;

        // 子数组的
        int len=nums.length+1;

        // 子数组的长度
        int min=Integer.MAX_VALUE;

        int sum=0;

        while(left<nums.length&&right<nums.length){
            while(sum<s&&right<nums.length){
                // 右指针往右 扩大窗口
                sum+=nums[right++];
            }
            while(sum>=s&&left<=right){
                min=Math.min(min,right-left);
                // 左指针往右 缩小窗口
                sum-=nums[left++];
            }
        }
        return min==Integer.MAX_VALUE ? 0 : min;
    }
}
