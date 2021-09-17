package leetcode.leetcode277;

/**
 * 277. 搜寻名人
 * https://leetcode-cn.com/problems/find-the-celebrity/
 *
 * @author Eivense
 * @date 2021/9/9 11:25 下午
 */
public class Solution {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            // 如果candidate 认识i 则candidate肯定不是名人
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == candidate) {
                continue;
            }
            // 如果i不认识candidate 则肯定不是
            if (!knows(i, candidate)) {
                return -1;
            }
            // 如果candidate 认识i 则肯定不是
            if (knows(candidate, i)) {
                return -1;
            }
        }
        return candidate;
    }


    /**
     *
     * knows(a,b)=true a认识b a肯定不是名人
     * knows(a,b)=false a不认识b b肯定不是名人
     */
    // a是否认识b
    public boolean knows(int a, int b) {
        return true;
    }
}
