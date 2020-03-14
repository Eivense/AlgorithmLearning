package leetcode.leetcode338;

/**
 * 338. Counting Bits
 *
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 *
 * Input: 5
 * Output: [0,1,1,2,1,2]
 *
 *
 */
public class Solution {

    public int[] countBits(int num) {
        if(num==0)
            return new int[]{0};
        int[] result=new int[num+1];
        for(int i=1;i<=num;i++){
            // 奇数
            if((i&1)==1){
                result[i]=result[i-1]+1;
            }
            // 偶数
            else{
                result[i]=result[i/2];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countBits(2);
    }
}
