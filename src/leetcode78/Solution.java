package leetcode78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78. Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 *
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }


    private void dfs(List<List<Integer>> result, List<Integer> item, int[] nums, int len) {
        result.add(new ArrayList<>(item));
        for (int i = len; i < nums.length; i++) {
            item.add(nums[i]);
            dfs(result, item, nums, i + 1);
            item.remove(item.size() - 1);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.subsets(new int[]{1, 2, 3});
    }

}
