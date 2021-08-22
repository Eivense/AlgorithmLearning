package leetcode.leetcode273;

import java.util.ArrayList;
import java.util.List;

/**
 * 273. 整数转换英文表示
 * https://leetcode-cn.com/problems/integer-to-english-words/
 *
 * @author Eivense
 * @date 2021/8/17 10:28 下午
 */
public class Solution {

    // 个位 0-9
    String[] ones = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    // 十位 10-19
    String[] teens = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    // 20-90
    String[] tens = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    // 百 千 十万 百万
    String[] others = new String[]{"Billion", "Million", "Thousand", "Hundred"};

    public String numberToWords(int num) {
        if (num == 0) {
            return ones[num];
        }
        int[] units = new int[]{1000000000, 1000000, 1000, 100, 1};
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (num > 0 && i <= 4) {
            int unit = units[i];
            // 余数
            int a = num % unit;
            // 系数
            int b = (num - a) / unit;
            if (b > 0) {
                if (i == 4) {
                    calculate(b, -1, list);
                } else {
                    calculate(b, i, list);
                }
            }
            num = a;
            i++;
        }
        for (int j = 0; j < list.size(); j++) {
            stringBuilder.append(list.get(j));
            if (j != list.size() - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }

    // 三位数 拆分
    public void calculate(int num, int unit, List<String> list) {
        // 百位
        int hundred = num / 100;
        // 十位
        int ten = (num - (hundred * 100)) / 10;
        // 个位
        int one = num - (hundred * 100 + ten * 10);
        if (hundred != 0) {
            list.add(ones[hundred]);
            list.add(others[3]);
        }
        if (ten != 0) {
            if (ten >= 2) {
                list.add(tens[ten - 2]);
            }
            // 十位为1
            else {
                list.add(teens[one]);
                // 不为-1 则说明有单位
                if (unit != -1) {
                    list.add(others[unit]);
                }
                return;
            }
        }
        // 个位
        if (one != 0) {
            list.add(ones[one]);
        }

        // 不为-1 则说明有单位
        if (unit != -1) {
            list.add(others[unit]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberToWords(1234567891));
    }
}
