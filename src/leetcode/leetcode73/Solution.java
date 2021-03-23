package leetcode.leetcode73;

/**
 * 73. 矩阵置零
 * 给定一个m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用 O(mn)的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m+n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 *
 * @author Eivense
 * @date 2021/3/21 9:44 下午
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 第一列是否有0
        boolean flag1=false;
        // 第一行是否有0
        boolean flag2=false;

        for (int i = 0; i < m; i++) {
            // 第一行是否有0
            if (matrix[0][i] == 0) {
                flag1=true;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            // 第一列是否有0
            if (matrix[i][0] == 0) {
                flag2=true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // 用第一行和第一列标记
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (flag1) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flag2) {
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
