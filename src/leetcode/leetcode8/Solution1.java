package leetcode.leetcode8;

/**
 * @author Eivense
 * @date 2021/9/25 3:05 下午
 */
public class Solution1 {
    public int myAtoi(String s) {
        if(s.length()==0){
            return 0;
        }
        // 去除空格
        s = s.trim();
        // 负数
        boolean flag = false;
        int i=0;
        int result = 0;

        // 处理首字符
        char head = s.charAt(0);
        if (head == '-') {
            flag = true;
            i++;
        } else if (head == '+') {
            i++;
        } else if (head < '0' || head > '9') {
            return 0;
        }
        while (i<s.length()) {

            char current = s.charAt(i);
            int digit;
            if (current >= '0' && current <= '9') {
                digit = current - '0';
            }else{
                break;
            }

            if (!flag) {
                if (result > (Integer.MAX_VALUE-digit) / 10) {
                    return Integer.MAX_VALUE;
                }
            }else{
                if (result*-1 < (Integer.MIN_VALUE +digit) / 10) {
                    return Integer.MIN_VALUE;
                }
            }

            result = result * 10 + digit;
            i++;
        }
        if (flag) {
            return result * -1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.myAtoi("-000000000000001"));
    }
}
