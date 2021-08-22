package leetcode.leetcode17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eivense
 * @date 2021/8/8 10:13 下午
 */
public class Solution1 {
    public List<String> letterCombinations(String digits) {
        // 2-9
        String[] numbers=new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        dfs(result,numbers,digits,"");
        return result;
    }

    public void dfs(List<String> result,String[] numbers,String digits,String s) {
        if (s.length() == digits.length()) {
            result.add(s);
        } else {
            int number = digits.charAt(s.length()) - '0';
            String temp = numbers[number - 2];
            // 循环数字对应的所有字符
            for (int j = 0; j < temp.length(); j++) {
                dfs(result, numbers, digits, s+temp.charAt(j));
            }
        }
    }
}
