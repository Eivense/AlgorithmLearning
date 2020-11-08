package interview.interview10_02;

import java.util.*;

/**
 * 面试题 10.02. 变位词组
 *
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 *
 * 注意：本题相对原题稍作修改
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            String key = sortString(str);
            List<String> list = map.get(key);
            if (list == null) {
                List<String> value = new ArrayList<>();
                value.add(str);
                map.put(key, value);
            }else{
                list.add(str);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            result.add((List<String>) entry.getValue());
        }
        return result;
    }

    public String sortString(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }
}
