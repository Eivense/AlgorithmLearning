package leetcode.leetcode443;

/**
 * 443. 压缩字符串
 * https://leetcode-cn.com/problems/string-compression/
 *
 * @author Eivense
 * @date 2021/9/20 8:20 下午
 */
public class Solution {
    public int compress(char[] chars) {

        int read = 0;
        int write = 0;
        while (read < chars.length) {
            // write从读的后一位开始
            int start = read;
            // 重复的数量
            int num = 1;
            // 直到找到不同的
            while (read + 1 < chars.length && chars[read] == chars[read + 1]) {
                read++;
                num++;
            }
            chars[write++] = chars[start];
            // 数量大于1需要记录
            if (num > 1) {
                // 把个数也转换成数组
                char[] numsArray = String.valueOf(num).toCharArray();
                for (char c : numsArray) {
                    chars[write++] = c;
                }
            }
            read++;
        }
        return write;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] chars=new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(solution.compress(chars));
        System.out.println(chars);

    }
}
