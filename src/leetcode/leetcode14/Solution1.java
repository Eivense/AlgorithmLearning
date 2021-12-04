package leetcode.leetcode14;

/**
 * @author Eivense
 * @date 2021/10/10 9:39 下午
 */
public class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        String last = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String current = strs[i];
            int index = 0;
            int length = Math.min(last.length(), current.length());
            while (index < length) {
                if (last.charAt(index) == current.charAt(index)) {
                    index++;
                }else{
                    break;
                }
            }
            last = current.substring(0, index);
        }
        return last;
    }
}
