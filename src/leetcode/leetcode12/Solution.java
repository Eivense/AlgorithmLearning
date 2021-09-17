package leetcode.leetcode12;

import java.util.HashMap;
import java.util.Map;

/**
 * 12. 整数转罗马数字
 * https://leetcode-cn.com/problems/integer-to-roman/
 *
 * @author Eivense
 * @date 2021/9/14 9:30 下午
 */
public class Solution {

    public String intToRoman(int num) {
        Integer[] nums = new Integer[]{1000,900, 500,400,100,90,50,40, 10,9, 5,4, 1};
        String[] romans = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        int start = 0;
        StringBuilder result = new StringBuilder();
        while (num > 0) {

            int temp = nums[start];
            int quotient = num / temp;
            if (quotient > 0) {
                for (int i = 0; i < quotient; i++) {
                    result.append(romans[start]);
                }
                num = num - quotient * temp;
            }
            start++;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(58));

    }
}
