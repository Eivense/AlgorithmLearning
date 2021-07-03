package leetcode.leetcode1833;

import java.util.Arrays;

/**
 * 1833. 雪糕的最大数量
 *
 * https://leetcode-cn.com/problems/maximum-ice-cream-bars/
 * @author Eivense
 * @date 2021/7/3 1:55 下午
 */
public class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int num = 0;
        // 排序 从小到大
        Arrays.sort(costs);

        for (int i = 0; i < costs.length; i++) {
            if (coins >= costs[i]) {
                num++;
                coins = coins - costs[i];
            }else{
                break;
            }
        }
        return num;
    }
}
