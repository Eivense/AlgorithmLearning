package leetcode75;

/**
 * 75. Sort Colors
 *
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 *
 */
public class Solution {
    public void sortColors(int[] nums) {
        sort(nums, 0, nums.length-1);
    }

    private static void sort(int[] nums,int left,int right){
        if(left>=right)
            return ;

        int zero=left-1;
        int two=right+1;

        int one=left;

        while(one<two){
            if(nums[one]==0){
                swap(nums,one,zero+1);
                one++;
                zero++;
            }else if(nums[one]==2){
                swap(nums, one, two - 1);
               two--;
            }else{
                one++;
            }
        }

    }

    private static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int [] a={2,0,2,1,1,0};
        solution.sortColors(a);
    }




}
