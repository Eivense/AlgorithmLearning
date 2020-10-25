package leetcode.leetcode234;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * <p>
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head!= null) {
            values.add(head.val);
            head = head.next;
        }

        int length = values.size();
        int p=0;
        int q = length - 1;
        while (p<q) {
            if (!values.get(p).equals(values.get(q))) {
                return false;
            }
            p++;
            q--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);

        head.next = a;
        System.out.println(solution.isPalindrome(head));

    }
}
