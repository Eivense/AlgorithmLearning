package offer.offer62;

import java.util.*;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 *
 * @author Eivense
 * @date 2021/9/26 9:42 下午
 */
public class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array.add(i);
        }
        int index = m - 1;
        while (n > 1) {
            index = (index + 1) % n;
            array.remove(index);
            n--;
        }
        return array.get(index+1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lastRemaining(5, 3);
    }
}
