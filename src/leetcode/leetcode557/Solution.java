package leetcode.leetcode557;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 */
public class Solution {
    public String reverseWords(String s) {
        String[] list = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<list.length;i++){
            String word = list[i];
            for(int j=word.length()-1;j>=0;j--){
                builder.append(word.charAt(j));
            }
            if(i!=list.length-1){
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }
}
