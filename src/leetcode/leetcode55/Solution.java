package leetcode.leetcode55;

/**
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 *
 * @author Eivense
 * @date 2021/11/22 9:15 下午
 */
public class Solution {

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.canJump(new int[]{2, 3, 1, 1, 4});
    }
}
