package leetcode.leetcode253;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 253. 会议室 II
 *
 * https://leetcode-cn.com/problems/meeting-rooms-ii/
 *
 * @author Eivense
 * @date 2021/7/31 3:59 下午
 */
public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int rooms = 0;
        int max = 1;
        // 会议数量
        int meetings = intervals.length;

        int[] start = new int[meetings];
        int[] end = new int[meetings];
        for (int i = 0; i < meetings; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int i=0;
        int j = 0;
        while(i<meetings&&j<meetings){
            if (start[i] < end[j]) {
                i++;
                rooms++;
            }else{
                rooms--;
                j++;
            }
            if (rooms > max) {
                max = rooms;
            }
        }
        return max;
    }
}
