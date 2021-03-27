package leetcode.leetcode61;

/**
 * @author Eivense
 * @date 2021/3/27 4:28 下午
 */
public class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int step = length-k % length;
        if (step == length) {
            return head;
        }
        temp = head;
        for (int i = 0; i < step; i++) {
            temp = temp.next;
        }
        // 新的头
        result.next = temp;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        for (int i = 0; i < step ; i++) {
            temp = temp.next;
        }
        temp.next = null;
        return result.next;
    }
}
