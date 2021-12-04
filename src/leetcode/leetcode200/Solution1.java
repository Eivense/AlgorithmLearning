package leetcode.leetcode200;

import leetcode.leetcode498.Solution;

/**
 * @author Eivense
 * @date 2021/11/25 10:11 下午
 */
public class Solution1 {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'&&!visited[i][j]) {
                    dfs(grid, visited, i, j, m, n);
                    // 全部搜索完之后 岛屿+1
                    result++;
                }
            }
        }
        return result;
    }


    public void dfs(char[][] grid, boolean[][] visited, int x, int y, int m, int n) {
        // 超出边界
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }
        // 还未访问过 且是岛屿
        if (!visited[x][y]&&grid[x][y]=='1') {
            visited[x][y] = true;
            // 往上
            dfs(grid, visited,x - 1, y, m, n);
            // 往下
            dfs(grid, visited, x + 1, y, m, n);
            // 往左
            dfs(grid, visited, x, y - 1, m, n);
            // 往右
            dfs(grid, visited, x, y + 1, m, n);
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        char[][] grid=new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        solution1.numIslands(grid);
    }
}
