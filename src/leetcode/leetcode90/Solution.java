package leetcode.leetcode90;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 90. 子集 II
 * https://leetcode-cn.com/problems/subsets-ii/
 *
 * @author Eivense
 * @date 2021/10/15 12:41 上午
 */
public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new boolean[nums.length],0, result, new LinkedList<>());
        return result;
    }

    public void dfs(int[] nums,boolean[] used, int len, List<List<Integer>> result, List<Integer> list) {
        result.add(new ArrayList<>(list));

        for (int i = len; i < nums.length; i++) {
            // 元素相同且上一个元素已经被使用了则返回
            if (i > 0 && nums[i - 1] == nums[i] && !used[i-1]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            dfs(nums, used,i + 1, result, list);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
