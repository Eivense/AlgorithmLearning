package leetcode.leetcode78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Eivense
 * @date 2021/10/14 11:07 下午
 */
public class Solution1 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int n=nums.length;

        int total=1<<n;

        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            temp.clear();
            for (int j = 0; j < n; j++) {
                if ((i&(1<<j))!=0) {
                    temp.add(nums[j]);
                }
            }
            result.add(new ArrayList<>(temp));
        }

        return result;
    }


}
