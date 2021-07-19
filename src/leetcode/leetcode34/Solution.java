package leetcode.leetcode34;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author Eivense
 * @date 2021/7/13 10:11 下午
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            }else{
                return new int[]{-1, -1};
            }
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int value = nums[mid];
            if (value== target) {
                int start = mid;
                int end = mid;
                while (start>=left&&nums[start]==target) {
                    start--;
                }
                start++;
                while (end<=right&&nums[end] == target) {
                    end++;
                }
                end--;
                int[] result = new int[2];
                result[0] = start;
                result[1] = end;
                return result;
            } else if (value > target) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchRange(new int[]{1,4}, 4));
    }
}
