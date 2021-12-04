package leetcode.leetcode2001;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 2001. 可互换矩形的组数
 * https://leetcode-cn.com/problems/number-of-pairs-of-interchangeable-rectangles/
 *
 * @author Eivense
 * @date 2021/9/20 11:23 下午
 */
public class Solution {
    /**
     * NC2 组合  N*(N-1)/2 相同长宽比的个数
     *
     */
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Long> map = new HashMap<>();
        for (int i = 0; i < rectangles.length; i++) {
            int[] rectangle = rectangles[i];
            double temp = (double) rectangle[0] / rectangle[1];
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            }else{
                map.put(temp, (long)1);
            }
        }
        long result = 0;
        for (Map.Entry<Double, Long> entry : map.entrySet()) {
            long n = entry.getValue();
            result += n * (n - 1) / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] rectangles = new int[][]{{4,8},{3,6},{10,20},{15,30}};
        solution.interchangeableRectangles(rectangles);
    }
}
