package leetcode.leetcode59;

/**
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * @author Eivense
 * @date 2021/3/16 9:27 下午
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int index=1;
        int left=0;
        int right=n-1;
        int top=0;
        int bottom=n-1;
        while (index <=(n*n+1)) {
            // 往右
            for (int i = left; i <= right; i++) {
                result[top][i]=index++;
            }
            top++;
            if (top > bottom) {
                break;
            }
            // 往下
            for (int i = top; i <= bottom; i++) {
                result[i][right]=index++;
            }
            right--;
            if (right < left) {
                break;
            }
            // 往左
            for (int i = right; i >= left; i--) {
                result[bottom][i]=index++;
            }
            bottom--;
            if (bottom < top) {
                break;
            }
            // 往上
            for (int i = bottom; i >= top; i--) {
                result[i][left]=index++;
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution=new Solution();

        System.out.println(solution.generateMatrix(3));
    }
}
