package leetcode.leetcode179;

/**
 * 179. 最大数
 * https://leetcode-cn.com/problems/largest-number/
 *
 * @author Eivense
 * @date 2021/8/24 11:15 下午
 */
public class Solution {
    public String largestNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                // 比较大小 1表示大 -1表示小 0表示相等
                int result = compare(nums[i], nums[j]);
                // 大的往后
                if (result == 1) {
                    // i大于j
                    int temp=nums[j];
                    nums[j]=nums[i];
                    nums[i] = temp;
                }
            }
        }
        if (nums[nums.length - 1] == 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = nums.length-1; i >= 0; i--) {
            stringBuilder.append(nums[i]);
        }
        return stringBuilder.toString();
    }

    public int compare(int numa, int numb) {
        String a = String.valueOf(numa);
        String b = String.valueOf(numb);

        String temp1=a+b;
        String temp2=b+a;
        // ab 比 ba
        if (temp1.compareTo(temp2) > 0) {
            return 1;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestNumber(new int[]{34323,3432}));
    }

}
