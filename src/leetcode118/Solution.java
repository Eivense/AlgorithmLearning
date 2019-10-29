package leetcode118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118 杨辉三角
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 *
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows==0){
            return result;
        }
        List<Integer> one = new ArrayList<>();
        one.add(1);
        // 第一行
        result.add(one);
        for(int i=0;i<numRows;i++){
            List<Integer> list = new ArrayList<>();
            // 获取上一行
            List<Integer> last=result.get(i-1);
            // 最左
            list.add(1);
            for(int j=1;j<i;j++){
                Integer m=last.get(j-1);
                Integer n = last.get(j);
                list.add(m==null?0:m+(n==null?0:n));
            }
            // 最右
            list.add(1);
            result.add(list);
        }
        return result;
    }
}
