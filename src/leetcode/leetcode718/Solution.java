package leetcode.leetcode718;

/**
 * 718. Maximum Length of Repeated Subarray
 *
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 *
 * Example 1:
 *
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 *
 *
 */
public class Solution {
    public int findLength(int[] A, int[] B) {
        int matrix[][]=new int[A.length+1][B.length+1];

        int max=0;

        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=B.length;j++){
                if(A[i-1]==B[j-1]){
                    matrix[i][j]=matrix[i-1][j-1]+1;
                }
                max=Math.max(max,matrix[i][j]);
            }
        }
        return max;
    }
}
