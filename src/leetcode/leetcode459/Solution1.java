package leetcode.leetcode459;

import leetcode.leetcode345.Solution;

/**
 * 459. 重复的子字符串
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 *
 * @author Eivense
 * @date 2021/8/22 6:28 下午
 */
public class Solution1 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        String subString = "";
        boolean flag=false;
        for (int i = 0; i < n; i++) {
            flag=false;
            subString += s.charAt(i);
            int subLength = subString.length();
            int j=i+1;
            while(j+subLength<=n){
                String subTemp = s.substring(j, j + subLength);
                if (subTemp.equals(subString)) {
                    j = j + subLength;
                    flag=true;
                }else{
                    break;
                }
            }
            if (j == n) {
                return flag;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.repeatedSubstringPattern("abcabcabcabc"));
    }
}
