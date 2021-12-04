package leetcode.leetcode2002;

import java.util.ArrayList;
import java.util.List;

/**
 * 2002. 两个回文子序列长度的最大乘积
 * https://leetcode-cn.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/
 *
 * @author Eivense
 * @date 2021/9/21 2:20 下午
 */
public class Solution {
    public int maxProduct(String s) {
        int n = s.length();
        // 总共需要枚举的次数
        int total = 1 << n;
        List<Integer> list = new ArrayList<>();
        List<Integer> len = new ArrayList<>();
        // 找到所有回文串
        for (int i = 0; i < total; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                // 这一位为1
                if ((i >> j & 1) == 1) {
                    stringBuilder.append(s.charAt(j));
                }
            }
            String subString = stringBuilder.toString();
            if (check(subString)) {
                list.add(i);
                len.add(subString.length());
            }
        }

        int result = 0;
        // 遍历所有回文串
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i);
            int aLength = len.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int b = list.get(j);
                // 是否交叉
                if ((a&b)==0) {
                    // 计算乘积
                    int bLength = len.get(j);
                    result = Math.max(aLength * bLength, result);
                }
            }
        }
        return result;
    }


    public boolean check(String sub) {
        int i = 0;
        int j = sub.length() - 1;
        while (i < j) {
            if (sub.charAt(i) != sub.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(32 >> 4&1 );
    }
}
