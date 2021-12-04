package leetcode.leetcode143;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Eivense
 * @date 2021/10/12 12:08 上午
 */
public class Solution1 {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 快指针走到尾
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = null;
            stack.push(slow);
            slow = next;
        }
        ListNode temp = head;
        while (!stack.isEmpty()) {
            ListNode current = stack.pop();
            ListNode next = temp.next;
            temp.next=current;
            current.next = next;
            temp = next;
        }
        if (temp != null) {
            temp.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;

        Solution1 solution = new Solution1();
        solution.reorderList(listNode1);

    }
}
