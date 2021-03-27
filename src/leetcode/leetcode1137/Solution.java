package leetcode.leetcode1137;

/**
 * 1137. 第 N 个泰波那契数
 * 泰波那契序列Tn定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即answer <= 2^31 - 1。
 *
 * @author Eivense
 * @date 2021/3/23 11:04 下午
 */
public class Solution {
    private int[] result = new int[39];

    public Solution() {
        result[1] = 1;
        result[2] = 1;
        result[3] = 1;
        for (int i = 4; i < 38; i++) {
            result[i] = result[i - 1] + result[i - 2] + result[i - 3];
        }
    }

    public int tribonacci(int n) {
        return result[n];
    }

}
