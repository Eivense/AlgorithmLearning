package leetcode.leetcode54;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * @author Eivense
 * @date 2021/3/15 10:20 下午
 */
public class Solution {


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        // 行
        int m = matrix.length;
        // 列
        int n = matrix[0].length;

        int left=0;
        int right=n-1;
        int top=0;
        int bottom=m-1;

        while (true) {
            // 往右
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) {
                break;
            }
            // 往下
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }
            // 往左
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            if (bottom < top) {
                break;
            }
            // 往上
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }

        return result;
    }
}
