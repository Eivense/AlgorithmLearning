package leetcode.leetcode93;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 *
 * @author Eivense
 * @date 2021/9/26 11:36 下午
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backtrace(s, 0,list , result);
        return result;
    }

    public void backtrace(String s, int index, List<String> list, List<String> result) {
        if (list.size() == 4&&index==s.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                stringBuilder.append(list.get(i));
                if (i != 3) {
                    stringBuilder.append(".");
                }
            }
            result.add(stringBuilder.toString());
        }

        if (list.size()==4) {
            return ;
        }
        if (index == s.length()) {
            return;
        }

        // 最多取三位
        for (int i = 1; i <=3; i++) {
            int lastIndex = index + i;
            if (lastIndex > s.length()) {
                break;
            }
            String subString = s.substring(index, lastIndex);
            if (check(subString)) {
                list.add(subString);
                backtrace(s, lastIndex, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean check(String s) {
        if (s.length() == 0) {
            return false;
        }
        // 有前置0
        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }
        return Integer.parseInt(s) <= 255;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.restoreIpAddresses("25525511135");
    }
}
