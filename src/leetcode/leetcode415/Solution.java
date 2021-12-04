package leetcode.leetcode415;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 415. 字符串相加
 * https://leetcode-cn.com/problems/add-strings/
 *
 * @author Eivense
 * @date 2021/9/23 10:28 下午
 */
public class Solution {

    public String addStrings(String num1, String num2) {
        // 双指针
        int n = num1.length()-1;
        int m = num2.length()-1;

        int jinwei = 0;
        // 从尾开始
        StringBuilder stringBuilder = new StringBuilder();

        while (n >= 0 || m >= 0 || jinwei != 0) {
            int c1 = n >= 0 ? num1.charAt(n) - '0' : 0;
            int c2 = m >= 0 ? num2.charAt(m) - '0' : 0;
            // 计算进位
            int c = c1 + c2 + jinwei;
            if (c >= 10) {
                c = c - 10;
                jinwei = 1;
            } else {
                jinwei = 0;
            }
            stringBuilder.append((char) (c + '0'));
            n--;
            m--;
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.addStrings("11", "123");
    }
}
