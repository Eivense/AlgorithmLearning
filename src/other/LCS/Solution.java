package other.LCS;

import java.util.HashSet;
import java.util.Set;

/**
 * LCS 03. 主题空间
 * https://leetcode-cn.com/problems/YesdPw/
 *
 * @author Eivense
 * @date 2021/8/19 9:43 下午
 */
public class Solution {

    boolean flag=false;
    public int largestArea(String[] grid) {
        // 长
        int m=grid.length;
        // 宽
        int n=grid[0].length();
        int result=0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 重新初始化
                flag=false;
                char current = grid[i].charAt(j);
                int area=dfs(i, j, grid, current, visited);
                // 如果这次计算的区域碰到了走廊 则不算
                if(!flag){
                    result = Math.max(result, area);
                }
            }
        }
        return result;
    }

    public int dfs(int i,int j,String[] grid,char target,boolean[][] visited){
        // 长
        int m=grid.length;
        // 宽
        int n=grid[0].length();


        // 超出边界 或者是走廊
        if(i<0||i>=m||j<0||j>=n||grid[i].charAt(j)=='0'){
            // 标记碰到了走廊
            flag=true;
            return 0;
        }
        char c = grid[i].charAt(j);
        // 如果还没有访问过
        if(!visited[i][j]){
            if(c==target){
                // 标记为访问过
                visited[i][j]=true;
                // 往上
                int up=dfs(i,j-1,grid,target,visited);
                // 往下
                int down=dfs(i,j+1,grid,target,visited);
                // 往左
                int left=dfs(i-1,j,grid,target,visited);
                // 往右
                int right=dfs(i + 1, j, grid,target, visited);


                // 计算面积
                return up + down + left + right+1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestArea(new String[]{"11111100000","21243101111","21224101221","11111101111"}));
    }
}
