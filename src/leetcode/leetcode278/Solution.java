package leetcode.leetcode278;

/**
 * 278. 第一个错误的版本
 * https://leetcode-cn.com/problems/first-bad-version/
 *
 * @author Eivense
 * @date 2021/7/11 10:13 下午
 */

class VersionControl{
    boolean isBadVersion(int version){
        return version == 2;
    }
}
public class Solution extends VersionControl{
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean bad = isBadVersion(mid);
            // true 往前检索
            if (bad) {
                right=mid;
            }
            // false 往后检索
            else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.firstBadVersion(2);
    }
}
