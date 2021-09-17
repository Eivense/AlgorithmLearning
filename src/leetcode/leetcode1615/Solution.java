package leetcode.leetcode1615;

/**
 * 1615. 最大网络秩
 * https://leetcode-cn.com/problems/maximal-network-rank/
 *
 * @author Eivense
 * @date 2021/8/25 10:22 下午
 */
public class Solution {

    public int maximalNetworkRank(int n, int[][] roads) {
        // 城市对数量
        int m = roads.length;
        // 保存节点关系
        int[][] matrix = new int[m][m];
        // 保存每个城市相连的道路数量
        int[] roadNum = new int[n];

        for (int i = 0; i < m; i++) {
            int[] road = roads[i];
            matrix[road[0]][road[1]]=1;
            matrix[road[1]][road[0]]=1;
            roadNum[road[0]]++;
            roadNum[road[1]]++;
        }

        int result = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int city1RoadNum=roadNum[i];
                int city2RoadNum = roadNum[j];
                int temp = city1RoadNum + city2RoadNum;
                if (matrix[i][j] == 1) {
                    temp--;
                }
                result = Math.max(result, temp);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.maximalNetworkRank(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}});
    }
}
