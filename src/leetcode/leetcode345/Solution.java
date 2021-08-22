package leetcode.leetcode345;

import java.util.*;

/**
 * 345. 反转字符串中的元音字母
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 *
 * @author Eivense
 * @date 2021/8/20 12:36 上午
 */
public class Solution {
    public String reverseVowels(String s) {
        char[] charArray=s.toCharArray();
        Set<Character> yuanyin = new HashSet<>();
        Collections.addAll(yuanyin,'a','A','e','E','i','I','o','O','u','U');

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            // 如果该字符是
            if (yuanyin.contains(c)) {
                charArray[i]=1;
                stack.push(c);
            }
        }

        for (int i = charArray.length; i >= 0; i--) {
            if (charArray[i] == 1) {
                charArray[i] = stack.pop();
            }
        }
        return new String(charArray);
    }

    public String reverseVowels1(String s) {
        char[] charArray=s.toCharArray();
        Set<Character> yuanyin = new HashSet<>();
        Collections.addAll(yuanyin,'a','A','e','E','i','I','o','O','u','U');


        // 双指针
        int i=0;
        int j=charArray.length-1;

        while (i < j) {
            while(!yuanyin.contains(charArray[i])&&i<j){
                i++;
            }
            while (!yuanyin.contains(charArray[j])&&i<j) {
                j--;
            }

            if(i<j){
                // 交换
                char ci=charArray[i];
                char cj=charArray[j];
                charArray[i]=cj;
                charArray[j]=ci;
                i++;
                j--;
            }
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels1("hello"));
    }
}
