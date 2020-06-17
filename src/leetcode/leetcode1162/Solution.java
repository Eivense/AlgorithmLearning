package leetcode.leetcode1162;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1162. 地图分析
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 *
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 * 示例 2：
 *
 *
 *
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 *  
 *
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 *
 */
public class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;

        // 四个方向 上下左右
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new ArrayDeque<>();
        // 第一次遍历找到所有陆地
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 陆地入队
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[] point = null;
        // 是否有海洋
        boolean hasOcean = false;
        while (!queue.isEmpty()) {
            // 出队
            point = queue.poll();
            int x = point[0];
            int y = point[1];
            // 往四个方向
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 不是海洋或者超出边界
                if ( newX < 0 || newX > n || newY < 0 || newY > n||grid[newX][newY] != 0) {
                    continue;
                }
                // 是海洋
                grid[newX][newY]=grid[x][y]+1;
                // 海洋继续入队列
                queue.offer(new int[]{newX, newY});
                hasOcean = true;
            }
        }
        // 全是陆地或者没有海洋
        if (point == null||!hasOcean) {
            return -1;
        }
        return grid[point[0]][point[1]]-1;

    }
}
