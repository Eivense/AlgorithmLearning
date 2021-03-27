package leetcode.leetcode83;

/**
 * 83. Remove Duplicates from Sorted List
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 *
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 *
 */

public class Solution {
    public ListNode deleteDuplicates2(ListNode head) {
        if(head==null)
            return null;

        ListNode current = head;
        while(current != null){
            while(current.next != null && current.val == current.next.val)
                current.next = current.next.next;
            current = current.next;
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }

}
