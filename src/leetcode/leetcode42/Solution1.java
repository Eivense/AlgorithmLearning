package leetcode.leetcode42;

/**
 * @author Eivense
 * @date 2021/9/26 11:16 下午
 */
public class Solution1 {

    public int trap(int[] height) {
        return dfs(height, 0, height.length - 1);
    }

    public int dfs(int[] height, int left, int right) {
        if (left == right) {
            return 0;
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max1Index = -1;
        int max2Index = -1;
        for(int i=left;i<=right; i++){
            int value = height[i];
            if (value > max1) {
                max2 = max1;
                max2Index=max1Index;
                max1 = value;
                max1Index = i;
            }else if(value>max2){
                max2 = value;
                max2Index = i;
            }
        }

        int min = Math.min(max1Index, max2Index);
        int max = Math.max(max2Index, max1Index);

        int top = Math.min(max1, max2);
        int area = top * (max - min - 1);;
        for (int i = min + 1; i < max; i++) {
            area = area - height[i];
        }

        return area+dfs(height, left, min )+
                dfs(height, max , right);
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] num = new int[]{ 4,2,3} ;
        System.out.println(solution.trap(num));

    }
}
