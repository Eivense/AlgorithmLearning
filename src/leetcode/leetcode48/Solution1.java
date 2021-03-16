package leetcode.leetcode48;

import leetcode.leetcode59.Solution;

/**
 * @author Eivense
 * @date 2021/3/16 11:30 下午
 */
public class Solution1 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // n/2圈
        for (int i = 0; i < n / 2; i++) {
            int len = n - i * 2;
            for (int j = 0; j < len-1; j++) {
                int temp = matrix[i][i + j];
                matrix[i][i + j] = matrix[i + len - 1 - j][i];
                matrix[i + len - 1 - j][i] = matrix[i + len - 1][i+len-j-1];
                matrix[i + len - 1][i + len - j - 1] = matrix[i + j][i + len - 1];
                matrix[i + j][i + len - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        int [][] test=new int[][]{{2,29,20,26,16,28},{12,27,9,25,13,21},{32,33,32,2,28,14},{13,14,32,27,22,26},{33,1,20,7,21,7},{4,24,1,6,32,34}};
        solution.rotate(test);
    }
}
