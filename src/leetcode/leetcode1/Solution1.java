package leetcode.leetcode1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eivense
 * @date 2021/9/24 11:16 下午
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                return new int[]{i, map.get(target - num)};
            }else{
                map.put(num, i);
            }
        }
        return null;
    }
}
