package leetcode.leetcode986;

import java.util.ArrayList;
import java.util.List;

/**
 * 986. 区间列表的交集
 * https://leetcode-cn.com/problems/interval-list-intersections/
 *
 * @author Eivense
 * @date 2021/8/22 10:10 下午
 */
public class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // 区间个数
        int n = firstList.length;

        // 区间个数
        int m = secondList.length;

        int i = 0;
        int j = 0;
        List<int[]> resultList = new ArrayList<>();
        while (i < n && j < m) {
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];
            int start2 = secondList[j][0];
            int end2 = secondList[j][1];

            int left = Math.max(start1, start2);

            int right = Math.min(end1, end2);

            if (left <= right) {
                resultList.add(new int[]{left, right});
            }

            if (end1 <= end2) {
                i++;
            }else{
                j++;
            }
        }

        int[][] result = new int[resultList.size()][2];

        for (int a = 0; a < resultList.size(); a++) {
            result[a] = resultList.get(a);
        }
        return result;
    }


}
