package leetcode.leetcode206;

/**
 * @author Eivense
 * @date 2021/9/23 9:59 下午
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {

        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous=current;
            current = next;
        }
        return previous;
    }
}
