package leetcode.leetcode206;

/**
 * @author Eivense
 * @date 2021/9/24 10:14 下午
 */
public class Solution2 {

    public ListNode reverseList(ListNode head) {

        ListNode previous = null;
        ListNode current = head;
        while (current!= null) {
            ListNode next = current.next;
            current.next=previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public ListNode reverseList1(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode newHead = reverseList1(head);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
