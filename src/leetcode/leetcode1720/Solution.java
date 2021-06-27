package leetcode.leetcode1720;

/**
 * 1720. 解码异或后的数组
 * https://leetcode-cn.com/problems/decode-xored-array/
 *
 * @author Eivense
 * @date 2021/6/20 9:44 下午
 */
public class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length+1];
        result[0] = first;
        for (int i =1; i <encoded.length+1; i++) {
            result[i] = result[i-1]^encoded[i-1];
        }
        return result;
    }
}
