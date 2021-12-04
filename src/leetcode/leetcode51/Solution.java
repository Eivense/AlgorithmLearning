package leetcode.leetcode51;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eivense
 * @date 2021/9/26 10:56 下午
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] matrix = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        backtrace(0, n, matrix, result);
        return result;
    }

    public void backtrace(int i, int n,boolean[][] matrix,List<List<String>> result) {
        if (i == n) {
            result.add(print(matrix));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (check(matrix, i, j, n)) {
                matrix[i][j] = true;
                // 下一行
                backtrace(i + 1, n, matrix,result);
                matrix[i][j] = false;
            }
        }
    }

    public boolean check(boolean[][] matrix, int x, int y,int n) {
        // 检查行
        for (int i = 0; i < n; i++) {
            // 这一列有皇后
            if (matrix[x][i]) {
                return false;
            }
        }
        // 检查列
        for (int i = 0; i < n; i++) {
            if (matrix[i][y]) {
                return false;
            }
        }
        // 检查斜线 往左上
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (matrix[i][j]) {
                return false;
            }
        }
        // 检查斜线 往右上
        for (int i = x - 1, j = y + 1; i >= 0 && j <= n; i--, j++) {
            if (matrix[i][j]) {
                return false;
            }
        }
        return true;
    }

    public List<String> print(boolean[][] matrix) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j]) {
                    stringBuilder.append("Q");
                }else{
                    stringBuilder.append(".");
                }
            }
            list.add(stringBuilder.toString());
        }
        return list;
    }

}
