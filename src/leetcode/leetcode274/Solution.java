package leetcode.leetcode274;

import java.util.Arrays;

/**
 * 274. H 指数
 * https://leetcode-cn.com/problems/h-index/
 *
 * @author Eivense
 * @date 2021/7/11 4:21 下午
 */
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        for (int i = 0; i < length; i++) {
            int num = length - i;
            if (num <= citations[i]) {
                return num;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.hIndex(new int[]{3, 0, 6, 1, 5});
    }
}
