package leetcode.leetcode1436;

import java.util.*;

/**
 * 1436. 旅行终点站
 * https://leetcode-cn.com/problems/destination-city/
 *
 * @author Eivense
 * @date 2021/10/1 1:53 下午
 */
public class Solution {

    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for (List<String> path : paths) {
            String start = path.get(0);
            set.add(start);
        }


        for (List<String> path : paths) {
            if (!set.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return null;
    }
}
