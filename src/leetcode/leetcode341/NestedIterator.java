package leetcode.leetcode341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 341. 扁平化嵌套列表迭代器
 *
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用next 直到hasNext 返回 false，next返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 *
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用next直到hasNext 返回 false，next返回的元素的顺序应该是: [1,4,6]。
 *
 *
 * @author Eivense
 * @date 2021/3/23 10:29 下午
 */


public class NestedIterator implements Iterator<Integer> {

    private List<Integer> list;
    private Iterator<Integer> iterator;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        dfs(nestedList);
        iterator = list.iterator();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    private void dfs(List<NestedInteger> nestedIntegerList) {
        for (NestedInteger nestedInteger : nestedIntegerList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            }else{
                dfs(nestedInteger.getList());
            }
        }
    }
}
