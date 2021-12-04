package leetcode.leetcode46;

import leetcode.leetcode322.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Eivense
 * @date 2021/10/11 9:41 下午
 */
public class Solution1 {

    private final List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new boolean[nums.length], new LinkedList<>());
        return result;
    }

    public void dfs(int[] nums,boolean[] visited,List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                temp.add(nums[i]);
                visited[i] = true;
                dfs(nums, visited, temp);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.permute(new int[]{1, 2, 3});
    }
}
