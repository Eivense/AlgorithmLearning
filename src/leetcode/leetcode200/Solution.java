package leetcode.leetcode200;

/**
 * 200. 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * @author Eivense
 * @date 2021/7/24 9:34 下午
 */
public class Solution {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] marker = new boolean[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'&&!marker[i][j]) {
                    result++;
                    dfs(grid, marker, i, j, m, n);
                }
            }
        }
        return result;
    }



    public void dfs(char[][] grid, boolean[][] marker, int i, int j,int m,int n) {
        if (i < m && i >= 0 && j < n && j >= 0) {
            // 如果还未访问过
            if (!marker[i][j]) {
                char c = grid[i][j];
                // 如果是岛屿的话 则便于该岛屿的全部
                if (c == '1') {
                    marker[i][j] = true;
                    // 往下
                    dfs(grid, marker, i + 1, j,m,n);
                    // 往上
                    dfs(grid, marker, i - 1, j,m,n);
                    // 往左
                    dfs(grid, marker, i, j - 1,m,n);
                    // 往右
                    dfs(grid, marker, i, j + 1,m,n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid=new char[][]{
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
    };
        System.out.println(solution.numIslands(grid));
    }

}
