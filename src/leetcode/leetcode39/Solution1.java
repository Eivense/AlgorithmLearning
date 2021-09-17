package leetcode.leetcode39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Eivense
 * @date 2021/9/7 10:05 下午
 */
public class Solution1 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,0,new LinkedList<>(), target);
        return result;
    }

    public void dfs(int[] candidates,int start,List<Integer> list,int target) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
        } else if (target < 0) {
            return ;
        }

        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            list.add(candidate);
            dfs(candidates,i, list, target - candidate);
            // 删除最后一个
            list.remove(list.size() - 1);
        }

    }
}
