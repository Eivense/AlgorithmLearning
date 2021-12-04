package leetcode.leetcode88;

/**
 * @author Eivense
 * @date 2021/9/23 10:09 下午
 */
public class Solution1 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // 双指针
        int a = m-1;
        int b = n-1;

        // 从后往前
        int index = m + n - 1;

        while (a >= 0 && b >= 0) {
            if (nums1[a] > nums2[b]) {
                nums1[index--]=nums1[a--];
            }else{
                nums1[index--] = nums1[b--];
            }
        }

        for (int i = a; i >= 0; i--) {
            nums1[index--] = nums1[i];
        }
        for (int i = b; i >= 0; i--) {
            nums1[index--]=nums2[i];
        }

    }
}
