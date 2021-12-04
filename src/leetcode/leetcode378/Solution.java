package leetcode.leetcode378;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 378. 有序矩阵中第 K 小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * @author Eivense
 * @date 2021/10/7 9:10 下午
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        // 维护一个大小为k的 小顶堆
        PriorityQueue<int[]> heap = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 数组第一位为value
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < n; i++) {
            // value row col
            heap.add(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            // 堆顶
            int[] top = heap.poll();
            int row = top[1];
            int col = top[2];
            if (col != n - 1) {
                heap.add(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }

        return heap.peek()[0];
    }

}
