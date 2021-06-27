package interview.interview17_10;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.10. 主要元素
 *
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 *
 * 示例 1：
 *
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *
 * 示例 2：
 *
 * 输入：[3,2]
 * 输出：-1
 *
 * 示例 3：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * @author Eivense
 * @date 2021/3/29 10:53 下午
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }else{
                int a = map.get(num) + 1;
                if (a > length / 2) {
                    return num;
                }
                map.put(num, a);
            }
        }
        return -1;
    }

}
