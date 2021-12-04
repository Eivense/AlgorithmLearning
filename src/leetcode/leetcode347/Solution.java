package leetcode.leetcode347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @author Eivense
 * @date 2021/10/18 10:19 下午
 */
public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            }else {
                int temp = map.get(num);
                map.put(num, temp + 1);
            }
        }
        // 小顶堆
        PriorityQueue<int[]> heap = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (heap.size() < k) {
                heap.add(new int[]{entry.getKey(), entry.getValue()});
            }else{
                // 堆顶
                int[] top = heap.peek();
                // 个数
                int count = entry.getValue();
                if (count > top[1]) {
                    heap.poll();
                    heap.add(new int[]{entry.getKey(), count});
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.topKFrequent(new int[]{1, 1, 1, 2, 3}, 2);
    }
}
