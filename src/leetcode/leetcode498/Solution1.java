package leetcode.leetcode498;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eivense
 * @date 2021/11/24 10:15 下午
 */
public class Solution1 {
    public int[] findDiagonalOrder(int[][] mat) {
        // 行
        int m = mat.length;
        // 列
        int n = mat[0].length;
        int length = m * n;
        int[] result = new int[length];

        // 起始坐标
        int x = 0;
        int y = 0;

        int index = 0;
        boolean flag = true;
        while (index <= length - 1) {
            int i = x;
            int j = y;
            // 先往右上再往左下
            if (flag) {
                // 往右上
                for (; i > 0 && j <n-1; i--, j++) {
                    result[index++] = mat[i][j];
                }
                result[index++] = mat[i][j];
                if (j < n - 1) {
                    y = j + 1;
                    x=0;
                } else {
                    x = i + 1;
                    y=n-1;
                }
                flag = false;
            } else {
                // 往左下
                for (; i < m-1 && j > 0; i++, j--) {
                    result[index++] = mat[i][j];
                }
                result[index++] = mat[i][j];
                if (i < m - 1) {
                    x = i + 1;
                    y=0;
                } else {
                    y = j + 1;
                    x=m-1;
                }
                flag = true;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
