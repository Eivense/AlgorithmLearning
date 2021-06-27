package offer.offer24;

/**
 * @author Eivense
 * @date 2021/3/29 9:47 下午
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        if (head == null||head.next==null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        // 环
        head.next.next=head;
        // 断环
        head.next=null;
        return newHead;
    }
}
