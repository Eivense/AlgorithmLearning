package leetcode.leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Eivense
 * @date 2021/9/26 10:43 下午
 */
public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 第一个数
            int first = nums[i];
            int secondIndex = i + 1;
            int thirdIndex = nums.length - 1;

            while (secondIndex < thirdIndex) {
                int target=first + nums[secondIndex] + nums[thirdIndex];
                if ( target== 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[secondIndex]);
                    temp.add(nums[thirdIndex]);
                    list.add(temp);
                    while (secondIndex<thirdIndex&&nums[thirdIndex] == nums[thirdIndex - 1]) {
                        thirdIndex--;
                    }
                    while (secondIndex < thirdIndex && nums[secondIndex] == nums[secondIndex + 1]) {
                        secondIndex++;
                    }
                    secondIndex++;
                    thirdIndex--;
                } else if (target > 0) {
                    thirdIndex--;
                }else{
                    secondIndex++;
                }
            }
        }
        return list;
    }
}
