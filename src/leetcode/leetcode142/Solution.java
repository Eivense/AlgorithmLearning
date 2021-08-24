package leetcode.leetcode142;

import leetcode.leetcode100.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author Eivense
 * @date 2021/8/22 10:55 下午
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (head != null) {
            if (!set.contains(head)) {
                set.add(head);
                head = head.next;
            }else{
                return head;
            }
        }
        return head;
    }
}
