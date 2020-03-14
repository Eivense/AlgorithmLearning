package leetcode.leetcode22;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, result);
        return result;
    }

    public void generate(int num,List<String> result){
        generateString(num-2, num, "(", '(',result);
        generateString(num-1, num-1, "(", ')',result);
    }

    public void generateString(int left,int right,String string,char c,List<String> result){
        string+=c;
        if (left == 0 && right == 0) {
            result.add(string);
        }
        if(left<0||right<left){
            return;
        }
        generateString(left-1,right,string,'(',result);
        generateString(left,right-1,string,')',result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}