package leetcode.leetcode207;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Eivense
 * @date 2021/12/4 1:45 下午
 */
public class Solution1 {

    // bfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 入度
        int[] indegree = new int[numCourses];

        // [a][b] 表示a到b
        boolean[][] temp = new boolean[numCourses][numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];

            // a->b
            int a=prerequisite[0];
            int b=prerequisite[1];

            temp[a][b] = true;
            indegree[b]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            // 入度为0的点
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;
            for (int i = 0; i < numCourses; i++) {
                if(temp[node][i]){
                    indegree[i]--;
                    // 入度为0则入队
                    if (indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return visited == numCourses;
    }

}
