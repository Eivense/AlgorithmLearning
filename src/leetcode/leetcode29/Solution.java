package leetcode.leetcode29;

/**
 * 29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        // 负数
        boolean positive = (dividend ^ divisor) >= 0;
        int quotient = 0;
        // 越界情况 单独处理
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        while (dividend <= divisor) {
            int tempQuotient=1;
            int tempDivisor = divisor;
            // 尝试增大除数
            while (dividend-tempDivisor<=tempDivisor) {
                // 左移一位 乘以2
                tempDivisor = tempDivisor << 1;
                tempQuotient=tempQuotient<<1;
            }
            quotient += tempQuotient;
            dividend -= tempDivisor;
        }
        return positive ? quotient : quotient * -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(100, -3));
    }
}
