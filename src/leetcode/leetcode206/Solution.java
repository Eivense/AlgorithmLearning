package leetcode.leetcode206;

/**
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author Eivense
 * @date 2021/8/22 6:08 下午
 */

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode newHead=head;
        ListNode pre=null;
        while (newHead.next!= null) {
            ListNode next = newHead.next;
            newHead.next=pre;
            pre=newHead;
            newHead=next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head.next=head1;
        head1.next=head2;
        head2.next=head3;
        head3.next=head4;
        Solution solution = new Solution();
        solution.reverseList(head);
    }
}
