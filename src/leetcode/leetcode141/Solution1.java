package leetcode.leetcode141;

/**
 * @author Eivense
 * @date 2021/9/23 9:39 下午
 */
public class Solution1 {

    public boolean hasCycle(ListNode head) {
        // 长度为0或者1
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
