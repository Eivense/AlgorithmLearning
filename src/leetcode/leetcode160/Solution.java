package leetcode.leetcode160;

/**
 * 160. 相交链表
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            if (p== null) {
                p = headB;
            }else{
                p = p.next;
            }
            if (q== null) {
                q = headA;
            } else {
                q = q.next;
            }
        }
        return p;
    }
}
