package leetcode.leetcode128;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 *
 * @author Eivense
 * @date 2021/10/2 8:04 下午
 */
public class Solution {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                dp[i] = dp[i - 1] + 1;
            }else if(nums[i]==nums[i-1]){
                dp[i] = dp[i - 1];
            }else{
                dp[i]=1;
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }


    public int longestConsecutive1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set=new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int result = Integer.MIN_VALUE;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int right=0;
                while (set.contains(num + 1)) {
                    num = num + 1;
                    right++;
                }
                result = Math.max(result, right);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(new int[]{1, 2, 0, 1}));
    }
}
