package leetcode.leetcode498;

import java.util.ArrayList;
import java.util.List;

/**
 * 498. 对角线遍历
 * https://leetcode-cn.com/problems/diagonal-traverse/
 *
 * @author Eivense
 * @date 2021/11/22 10:43 下午
 */
public class Solution {

    public int[] findDiagonalOrder(int[][] mat) {
        // 行
        int m = mat.length;
        // 列
        int n = mat[0].length;
        int length = m * n;
        int[] result = new int[length];

        int x=0;
        int y=0;

        int index=0;
        boolean flag = true;
        while (index <= length-1) {
            int i=x;
            int j=y;
            List<Integer> list = new ArrayList<>();
            while (i >= 0 && i < m && j >= 0 && j < n) {
                list.add(mat[i][j]);
                i--;
                j++;
            }
            if (x < m-1) {
                x++;
            }else{
                y++;
            }
            if (flag) {
                for (int k = 0; k < list.size(); k++) {
                    result[index++] = list.get(k);
                }
                flag = false;
            }else{
                for (int k = list.size() - 1; k >= 0; k--) {
                    result[index++] = list.get(k);
                }
                flag = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
