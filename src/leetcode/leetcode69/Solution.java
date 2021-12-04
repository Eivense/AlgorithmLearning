package leetcode.leetcode69;

/**
 * 69. Sqrt(x)
 * https://leetcode-cn.com/problems/sqrtx/
 *
 * @author Eivense
 * @date 2021/10/10 10:06 下午
 */
public class Solution {
    public int mySqrt(int x) {

        int left=0;
        int right = x;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int temp = mid * mid;
            if (temp<=x) {
                result = mid;
                left = mid+1;
            }else{
                right = mid - 1;
            }
        }
        return result;
    }
}
