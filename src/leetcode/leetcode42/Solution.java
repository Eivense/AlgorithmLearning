package leetcode.leetcode42;

/**
 * 42. 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * @author Eivense
 * @date 2021/7/3 2:45 下午
 */
public class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        return area(height, 0, height.length - 1);
    }


    public int area(int[] height, int left, int right) {
        if (left == right) {
            return 0;
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max1Index = -1;
        int max2Index = -1;
        for (int i = left; i <= right; i++) {
            if (height[i] > max1) {
                max2 = max1;
                max1 = height[i];
                max2Index = max1Index;
                max1Index = i;
            } else if (height[i] >max2) {
                max2 = height[i];
                max2Index = i;
            }
        }
        int leftIndex = Math.min(max1Index, max2Index);
        int rightIndex = Math.max(max1Index, max2Index);
        int area = Math.min(height[max1Index], height[max2Index]) * (rightIndex-leftIndex-1);
        for (int i = leftIndex+1; i <rightIndex; i++) {
            area = area - height[i];
        }
        area += area(height, left,leftIndex);
        area += area(height, rightIndex, right);
        return area;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = new int[]{ 4,2,3} ;
        System.out.println(solution.trap(num));

    }
}
