package leetcode.leetcode73;

/**
 * 73. 矩阵置零
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 *
 * @author Eivense
 * @date 2021/8/24 10:44 下午
 */
public class Solution1 {

    public void setZeroes(int[][] matrix) {

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; i++) {
                dfs(matrix, i, j, visited);
            }
        }
    }

    public void dfs(int[][] matrix, int i, int j,boolean[][] visited) {
        if (!visited[i][j]) {
            if (matrix[i][j] == 0) {
                for (int p = 0; p < matrix[0].length;p++) {
                    if(matrix[i][p]!=0){
                        matrix[i][p] = 0;
                        visited[i][p]=true;
                    }else{
                        dfs(matrix, i, p, visited);
                    }
                }
                for (int p = 0; p < matrix.length; p++) {
                    if(matrix[p][j]!=0) {
                        matrix[p][j]=0;
                        visited[p][j]=true;
                    }else{
                        dfs(matrix, p, j, visited);
                    }

                }
            }
        }
    }

}
