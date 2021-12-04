package leetcode.leetcode207;

/**
 * 207. 课程表
 * https://leetcode-cn.com/problems/course-schedule/
 *
 * @author Eivense
 * @date 2021/12/2 9:55 下午
 */
public class Solution {

    boolean result = true;

    // dfs 判断是否成环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // [a][b] 表示a到b
        boolean[][] temp = new boolean[numCourses][numCourses];
        // 构造图
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            int a = prerequisite[0];
            int b = prerequisite[1];
            // 先上b再上a 即a->b
            temp[a][b] = true;
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            dfs(temp, i, numCourses, visited);
        }
        return result;
    }

    // dfs判断是否成环 i为开始
    public void dfs(boolean[][] temp, int i, int n, int[] visited) {
        visited[i] = 1;
        for (int x = 0; x < n; x++) {
            boolean a = temp[i][x];
            // i到x 有线
            if (a) {
                // 还未访问过
                if (visited[x] == 0) {
                    dfs(temp, x, n, visited);
                } else if (visited[x] == 1) {
                    result=false;
                    return;
                }
            }
        }
        // 一次dfs结束
        visited[i] = -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.canFinish(2, new int[][]{{1, 0}});
    }

}
