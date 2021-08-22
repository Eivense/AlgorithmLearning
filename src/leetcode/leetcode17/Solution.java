package leetcode.leetcode17;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author Eivense
 * @date 2021/8/8 3:39 下午
 */
public class Solution {

    public List<String> letterCombinations(String digits) {

        // 2-9
        String[] numbers=new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        backtrace(result, numbers, 0, digits, new StringBuilder());
        return result;
    }

    public void backtrace(List<String> result, String[] numbers, int index, String digits, StringBuilder stringBuilder) {
        if (index == digits.length()) {
            result.add(stringBuilder.toString());
        } else {
            int number = digits.charAt(index) - '0';
            String temp = numbers[number - 2];
            // 循环数字对应的所有字符
            for (int j = 0; j < temp.length(); j++) {
                stringBuilder.append(temp.charAt(j));
                backtrace(result, numbers, index + 1, digits, stringBuilder);
                // 回溯删掉append的字符
                stringBuilder.deleteCharAt(index);
            }
        }
    }
}
