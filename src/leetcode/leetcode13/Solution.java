package leetcode.leetcode13;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * https://leetcode-cn.com/problems/roman-to-integer/
 *
 * @author Eivense
 * @date 2021/8/12 10:10 下午
 */
public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int value = 0;
        int i=0;
        while(i<s.length()-1){
            char c = s.charAt(i);
            char nextC = s.charAt(i + 1);
            if (c == 'I'&&(nextC == 'V' || nextC == 'X')) {
                value = value + map.get(nextC) - map.get(c);
                i=i+2;
            }else if(c=='X'&&(nextC=='L'||nextC=='C')){
                value = value + map.get(nextC) - map.get(c);
                i=i+2;
            }else if(c=='C'&&(nextC=='D'||nextC=='M')){
                value = value + map.get(nextC) - map.get(c);
                i=i+2;
            }else{
                value += map.get(s.charAt(i));
                i++;
            }
        }
        if (i == s.length() - 2) {
            value+=map.get(s.charAt(i+1));
        }
        return value;
    }
}
