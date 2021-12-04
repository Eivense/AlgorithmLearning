package leetcode.leetcode78;

import leetcode.leetcode518.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Eivense
 * @date 2021/10/14 11:38 下午
 */
public class Solution2 {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result, new LinkedList<>());
        return result;
    }


    public void dfs(int[] nums, int len, List<List<Integer>> result, List<Integer> list) {
        result.add(new ArrayList<>(list));
        for (int i = len;i<nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.subsets(new int[]{1, 2, 3});
    }

}
