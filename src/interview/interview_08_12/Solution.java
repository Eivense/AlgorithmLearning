package interview.interview_08_12;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.12. 八皇后
 * https://leetcode-cn.com/problems/eight-queens-lcci/
 * @author Eivense
 * @date 2021/9/7 11:25 下午
 */
public class Solution {

    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][] map = new int[n][n];
        dfs(0, map,n);
        return result;
    }

    public void dfs(int n,int[][] map,int target){
        if (n == target) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder builder = new StringBuilder();

                for (int j = 0; j < n; j++) {
                    builder.append(map[i][j]==0?".":"Q");
                }
                temp.add(builder.toString());
            }
            result.add(new ArrayList<>(temp));
            return;
        }

        // 新的一行安排棋子
        for (int i = 0; i < target; i++) {
            // 是否合法
            if (isValid(n, i,map, target)) {
                // 这一列没有则往上加
                map[n][i] = 1;
                dfs(n + 1, map, target);
                // 回溯重新置0
                map[n][i] = 0;
            }
        }
    }

    // x为行 y为列
    public boolean isValid(int x,int y,int[][] map,int n) {

        // 检查列
        for (int i = 0; i < x; i++) {
            if (map[i][y] == 1) {
                return false;
            }
        }

        // 检查对角线 往左上检查
        for(int i=x-1,j=y-1;i>=0&j>=0;i--,j--){
            if (map[i][j] == 1) {
                return false;
            }
        }

        // 检查对角线 往右上检查
        for (int i = x - 1, j = y + 1; i >= 0 & j < n; i--, j++) {
            if (map[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveNQueens(4);
    }
}
