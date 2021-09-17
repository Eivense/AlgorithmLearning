package leetcode.leetcode877;

/**
 * 877. 石子游戏
 * https://leetcode-cn.com/problems/stone-game/
 *
 * @author Eivense
 * @date 2021/9/6 10:41 下午
 */
public class Solution {

    public boolean stoneGame(int[] piles) {
        return dfs(piles, true, 0, piles.length - 1, 0, 0);
    }

    public boolean dfs(int[] piles,boolean alex,int left,int right,int curAlex,int curLee){
        if (left > right) {
            return curAlex > curLee;
        }
        // 如果alex拿
        boolean leftResult;
        boolean rightResult;
        if(alex){
            leftResult = dfs(piles, false, left + 1, right, curAlex + piles[left], curLee);
            rightResult = dfs(piles, false, left, right - 1, curAlex + piles[right], curLee);
        }else{
            leftResult = dfs(piles, true, left + 1, right, curAlex, curLee + piles[left]);
            rightResult = dfs(piles, true, left, right - 1, curAlex, curLee + piles[right]);
        }
        return leftResult || rightResult;
    }

    public boolean stoneGame1(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];

        for (int i = 0; i < piles.length; i++) {
            dp[i][i] = piles[i];
        }

        // 枚举石子堆长度
        for (int i = 1; i < piles.length; i++) {
            // 区间左端点
            for (int j = 0; j < piles.length - i; j++) {
                int right = j + i;
                // 拿左边
                int leftValue = piles[j] - dp[j + 1][right];
                // 拿右边
                int rightValue = piles[right] - dp[j][right - 1];

                dp[j][right] = Math.max(leftValue, rightValue);
            }
        }
        return dp[0][piles.length - 1]>0;
    }
}
