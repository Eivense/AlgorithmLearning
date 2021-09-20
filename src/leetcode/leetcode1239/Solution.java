package leetcode.leetcode1239;

import java.util.*;

/**
 * 1239. 串联字符串的最大长度
 * https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 *
 * @author Eivense
 * @date 2021/9/18 11:19 下午
 */
public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxLength(List<String> arr) {
        if (arr == null || arr.isEmpty()) {
            return 0;
        }else if (arr.size() == 1) {
            return arr.get(0).length();
        }else{
            dfs(arr,0,"");
            return max;
        }
    }


    public void dfs(List<String> arr,int index,String current) {
        if (index == arr.size()) {
            max = Math.max(max, current.length());
            return;
        }
        String temp = arr.get(index);
        // 不包含
        if (match(current, temp)) {
            dfs(arr, index + 1, current + temp);
        }
        dfs(arr, index + 1, current);
    }

    public boolean match(String s, String sub) {
        boolean[] a = new boolean[26];
        for (char c : s.toCharArray()) {
            int num = c - 'a';
            a[num] = true;
        }
        for (char c : sub.toCharArray()) {
            int num = c - 'a';
            if (!a[num]) {
                a[num] = true;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        List<String> test = new ArrayList<>();
//        test.add("cha");
//        test.add("r");
//        test.add("act");
//        test.add("ers");
//        System.out.println(solution.maxLength(test));

        int ch = 5;
        int mask = 0;
        mask |= 1 << ch;

        System.out.println(mask);
        System.out.println('a'+5);
    }
}
