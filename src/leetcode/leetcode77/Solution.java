package leetcode.leetcode77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 *
 * @author Eivense
 * @date 2021/10/16 6:02 下午
 */
public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, n, 1, k, new LinkedList<>());
        return result;
    }


    public void dfs(List<List<Integer>> result, int n, int start,int k, List<Integer> list) {
        // 满足k个数
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
        }

        // i-n
        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(result, n, i + 1, k, list);
            list.remove(list.size() - 1);
        }
    }

}
