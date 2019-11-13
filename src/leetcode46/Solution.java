package leetcode46;

import java.util.*;


/**
 * 46 全排列
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        sequence(result,nums,new boolean[nums.length],new ArrayDeque<>());
        return result;
    }

    public void sequence(List<List<Integer>> result, int[] nums, boolean[] visited, ArrayDeque<Integer> sequence) {
        if(sequence.size()==nums.length){
            result.add(Arrays.asList(sequence.toArray(new Integer[0])));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                sequence.push(nums[i]);
                sequence(result, nums, visited, sequence);
                sequence.pop();
                visited[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

}
