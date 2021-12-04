package leetcode.leetcode151;

/**
 * @author Eivense
 * @date 2021/10/11 9:58 下午
 */
public class Solution1 {
    public String reverseWords(String s) {
        // 去除空格
        s = s.trim();
        StringBuilder stringBuilder = new StringBuilder();
        int start = s.length() - 1;
        while (start >= 0) {
            int length = 0;
            while ((start-length)>0&&s.charAt(start-length) != ' ') {
                length++;
            }
            String temp = s.substring(start - length, start + 1).trim();
            if (!temp.equals("")) {
                stringBuilder.append(temp);
                stringBuilder.append(" ");
            }
            start = start - length-1;
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.reverseWords("a good   example");
    }

}
