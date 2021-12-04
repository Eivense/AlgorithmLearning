package leetcode.leetcode82;

/**
 * @author Eivense
 * @date 2021/9/25 1:49 下午
 */
public class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        // 虚拟头指针
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode current = newHead;
        while (current.next != null && current.next.next != null) {
            if (current.next.val != current.next.next.val) {
                current = current.next;
            }else{
                int val = current.next.val;
                while (current.next!=null&&current.next.val == val) {
                    current.next = current.next.next;
                }
            }
        }

        return newHead.next;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        Solution1 solution = new Solution1();

        solution.deleteDuplicates(head);
    }
}
