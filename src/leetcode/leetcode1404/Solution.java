package leetcode.leetcode1404;

/**
 * 1404. 将二进制表示减到 1 的步骤数
 *
 * https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
 *
 * @author Eivense
 * @date 2021/6/20 10:06 下午
 */
public class Solution {
    public int numSteps(String s) {
        int step = 0;
        while(!s.equals("1")){
            int lastIndex = s.length() - 1;
            char last = s.charAt(lastIndex);
            // 奇数
            if (last=='1') {
                String temp = "1";
                while(lastIndex>=0){
                    if (s.charAt(lastIndex) != '0') {
                        lastIndex--;
                        temp += '0';
                    }else{
                        break;
                    }
                }
                if (lastIndex == -1) {
                    s = temp;
                }else{
                    s = s.substring(0, lastIndex) + temp;
                }
                step++;
            }
            // 偶数
            else{
                // 右移一位
                s = s.substring(0, lastIndex);
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.numSteps("1101");
    }
}
