package leetcode.leetcode54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eivense
 * @date 2021/9/25 2:24 下午
 */
public class Solution1 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int top=0;
        int bottom = m - 1;
        int left=0;
        int right = n - 1;

        int total = n * m;
        int index = 0;
        while (true) {
            // 从左到右
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
                index++;
            }
            top++;
            if (top > bottom) {
                break;
            }
            // 从上到下
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
                index++;
            }
            right--;
            if (right < left) {
                break;
            }
            // 从右到左
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
                index++;
            }
            bottom--;
            if (bottom < top) {
                break;
            }
            // 从下到上
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
                index++;
            }
            left++;
            if (left > right) {
                break;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();


        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        solution1.spiralOrder(matrix);
    }
}
