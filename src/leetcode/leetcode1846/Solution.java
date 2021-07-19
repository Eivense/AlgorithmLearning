package leetcode.leetcode1846;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

/**
 * 1846. 减小和重新排列数组后的最大元素
 * https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging/
 *
 * @author Eivense
 * @date 2021/7/15 10:17 下午
 */
public class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }else{
            Arrays.sort(arr);
            arr[0] = 1;
            for (int i =1; i < arr.length; i++) {
                arr[i] = Math.min(arr[i], arr[i - 1] + 1);
            }
        }
        return arr[arr.length-1];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maximumElementAfterDecrementingAndRearranging(new int[]{209, 209, 209, 209, 209});
    }
}
