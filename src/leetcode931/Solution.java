package leetcode931;

/**
 * 931. Minimum Falling Path Sum
 *
 * Given a square array of integers A, we want the minimum sum of a falling path through A.
 *
 * A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 12
 * Explanation:
 * The possible falling paths are:
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 * The falling path with the smallest sum is [1,4,7], so the answer is 12.
 *
 *
 */
public class Solution {
    public int minFallingPathSum(int[][] A) {

        // 行
        int row=A.length;
        // 列
        int col=A[0].length;

        int path[][] = new int[row][col];

        // 设置第一行 就是原始数据的第一行
        for(int i=0;i<col;i++){
            path[0][i]=A[0][i];
        }

        // 从第二行开始往下走
        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                // 第一列
                if(j==0){
                    path[i][j] = A[i][j] + Math.min(path[i - 1][j], path[i - 1][j + 1]);
                }
                else{
                    // 最后一列
                    if(j==col-1){
                        path[i][j]=A[i][j]+Math.min(path[i-1][j-1],path[i-1][j]);
                    }else{
                        path[i][j]=A[i][j]+Math.min(Math.min(path[i-1][j-1],path[i-1][j]),path[i-1][j+1]);
                    }
                }
            }
        }

        int min=Integer.MAX_VALUE;
        for(int i=0;i<col;i++){
            min=Math.min(min,path[row-1][i]);
        }
       return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a[][]=new int[][]{{-19,57},{-40,-5}};
        solution.minFallingPathSum(a);
    }
}
