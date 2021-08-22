package leetcode.leetcode88;

/**
 * 88. 合并两个有序数组
 * <p>
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author Eivense
 * @date 2021/7/26 2:43 下午
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 双指针 从大的开始
        int i=m-1,j=n-1;
        // 当前位置
        int cur = nums1.length - 1;
        while (i >= 0 || j >= 0) {
            // 找到更大的那一个
            int max;
            // 如果nums1已经遍历完
            if (i == -1) {
                max = nums2[j--];
            }
            // 如果nums2已经遍历完
            else if (j == -1) {
                max = nums1[i--];
            } else if (nums1[i] > nums2[j]) {
                max = nums1[i--];
            }else{
                max = nums2[j--];
            }
            nums1[cur--] = max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
}
