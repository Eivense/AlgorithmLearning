package leetcode.leetcode240;

/**
 * 240. 搜索二维矩阵 II
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 * @author Eivense
 * @date 2021/7/25 3:27 下午
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] marker = new boolean[m][n];
        return dfs(matrix,marker,0,0, target);
    }

    public boolean dfs(int[][] matrix,boolean[][] marker, int i, int j, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (i >= 0 && i < m && j >= 0 && j < n) {
            if (!marker[i][j]) {
                int value = matrix[i][j];
                marker[i][j] = true;
                if (value == target) {
                    return true;
                } else if (value > target) {
                    // 往左 往上
                    return dfs(matrix, marker,i - 1, j, target) || dfs(matrix, marker,i, j - 1, target);
                }else{
                    // 往右 往下
                    return dfs(matrix, marker,i + 1, j, target)||dfs(matrix,marker, i, j + 1, target);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix=new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,147,24},
                {18,21,23,26,30}
        };
        System.out.println(solution.searchMatrix(matrix, 5));
    }
}
