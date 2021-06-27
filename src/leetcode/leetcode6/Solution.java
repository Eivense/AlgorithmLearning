package leetcode.leetcode6;

/**
 *
 * 6. Z 字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion/
 *
 *
 * @author Eivense
 * @date 2021/6/26 2:30 下午
 */
public class Solution {
    public String convert(String s, int numRows) {
        int length = s.length();
        if (length == 1||numRows==1) {
            return s;
        }
        // 行
        int m=numRows;
        int n=length/numRows+numRows+2;
        char[][] matrix = new char[m][n];

        // 行数
        int a = 0;
        // 列数
        int b = 0;
        for (int i = 0; i < length; i++) {
            // 如果是长度的倍数
            if (i % (2*numRows-2) == 0) {
                int temp = i / (2 * numRows - 2);
                matrix[0][temp*(numRows-1)] = s.charAt(i);
            }else{
                int temp = i % (2 * numRows - 2);
                int tempa = i / (2 * numRows - 2);
                if (temp < numRows) {
                    matrix[temp][tempa*(numRows-1)]=s.charAt(i);
                }else{
                    matrix[2*(numRows-1)-temp][tempa * (numRows-1)+(temp-numRows+1)] = s.charAt(i);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != '\u0000') {
                    stringBuilder.append(matrix[i][j]);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("A", 1));
    }
}