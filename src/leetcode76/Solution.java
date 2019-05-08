package leetcode76;

import java.util.HashMap;

/**
 * 76. Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 *
 *
 */
public class Solution {

    public String minWindow(String s, String t) {
        int[] S=new int[255];
        int[] T=new int[255];
        for(int i=0;i<t.length();i++){
            T[t.charAt (i)]++;
        }

        // 窗口指针
        int left=0;

        // 最小窗口的下标
        int minLeft=0;

        // 最小窗口的长度
        int minLen=s.length()+1;

        // 找到t中字符的个数
        int count=0;

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            S[c]++;

            // 说明c在t中出现 且还未超过
            if(S[c]<=T[c]){
                count++;
            }
            // 说明当前窗口中已经包含t中所有的元素 窗口为[left...i]
            if(count==t.length()){
                // 当窗口往左移动不会破坏当前窗口时
                // left中的字符是多余的或者t中不存在的时则右移
                while(left<i&&(S[s.charAt(left)]>T[s.charAt(left)])){
                    // 窗口向左移动
                    S[s.charAt(left)]--;
                    left++;
                }

                // 当前窗口大小
                if(i-left+1<minLen){
                    minLen=i-left+1;
                    minLeft=left;
                }

                // 当前的left也是t中出现的字符 所以右移 寻找新的符合条件的窗口
                S[s.charAt(left)]--;
                left++;
                count--;
            }
        }
        // 没有找到
        if(minLen>s.length())
            return "";
        return s.substring(minLeft,minLeft+minLen);
    }
}
