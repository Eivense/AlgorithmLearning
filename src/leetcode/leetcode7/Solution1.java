package leetcode.leetcode7;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Eivense
 * @date 2021/9/25 1:32 下午
 */
public class Solution1 {
    public int reverse(int x) {

        int result = 0;
        while (x != 0) {
            if(result<Integer.MIN_VALUE/10||result>Integer.MAX_VALUE/10){
                return 0;
            }
            int temp = x % 10;
            x = x / 10;
            result = result * 10 + temp;
        }
        return result;
    }
}
