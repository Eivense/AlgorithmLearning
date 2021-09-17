package leetcode.leetcode47;

import java.util.ArrayList;
import java.util.List;

/**
 * 47. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 *
 * @author Eivense
 * @date 2021/9/7 11:04 下午
 */
public class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
            return null;
    }

    public void dfs(int nums[], List<Integer> temp,int length) {
        if (temp.size() == length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            temp.add(num);
        }
    }
}
