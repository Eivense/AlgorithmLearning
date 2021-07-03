package leetcode.leetcode11;

/**
 * 11. 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author Eivense
 * @date 2021/7/3 2:02 下午
 */
public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int leftValue = height[left];
            int rightValue = height[right];
            int area = area(height, left, right);
            max = Math.max(max, area);
            if (leftValue > rightValue) {
                right--;
            }else{
                left++;
            }
        }
        return max;
    }


    /**
     *
     * 计算left和right区间内的面积
     * @param height 数组
     * @param left 左边柱子的下标
     * @param right 右边柱子的下标
     * @return 面积
     */
    public int area(int[] height,int left,int right) {
        if (left == right) {
            return 0;
        }
        // 两根中更短的那一根
        int min = Math.min(height[left], height[right]);
        return min * Math.abs(left - right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        solution.maxArea(height);
    }
}
