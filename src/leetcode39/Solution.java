package leetcode39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 39. Combination Sum
 *
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result,new ArrayList<>(),target,candidates,0);
        return result;
    }

    private void dfs(List<List<Integer>> list,List<Integer> item,int target,int[] candidates,int start){
        if(target==0){
            list.add(new ArrayList<>(item));
        }else if(target<0){
            return ;
        }else{
            for(int i=start;i<candidates.length;i++){
                item.add(candidates[i]);
                dfs(list,item,target-candidates[i],candidates,i);
                item.remove(item.size()-1);
            }
        }
    }
}
