package leetcode.leetcode56;

import java.util.*;

/**
 * 56. 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 * @author Eivense
 * @date 2021/10/20 10:43 下午
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int left=0;
        int right = 0;
        for (int i = 0; i < intervals.length; i++) {
            left = intervals[i][0];
            right = intervals[i][1];
            if (list.isEmpty()) {
                list.add(new int[]{left, right});
            }else{
                int[] temp = list.get(list.size() - 1);
                if (temp[1] >= left) {
                    temp[1] = Math.max(temp[1],right);
                }else{
                    list.add(new int[]{left, right});
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }
}
