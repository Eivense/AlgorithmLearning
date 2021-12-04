package leetcode.leetcode92;

import leetcode.leetcode173.TreeNode;

/**
 * @author Eivense
 * @date 2021/10/11 11:23 下午
 */
public class Solution1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode prev = fake;
        for (int i = 0; i < left-1; i++) {
            prev = prev.next;
        }
        ListNode rightNode = prev;
        for (int i = 0; i <right-left+1; i++) {
            rightNode = rightNode.next;
        }
        ListNode leftNode = prev.next;
        ListNode current = rightNode.next;
        reverse(leftNode, rightNode);
        prev.next = rightNode;
        leftNode.next = current;

        return fake.next;
    }

    public ListNode reverse(ListNode head,ListNode tail) {
        if (head == tail) {
            return head;
        }
        ListNode newHead = reverse(head.next, tail);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

//        ListNode listNode = new ListNode(1);
//        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(3);
//        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
//        listNode.next=listNode1;
//        listNode1.next=listNode2;
//        listNode2.next=listNode3;
//        listNode3.next = listNode4;

        solution.reverseBetween(listNode4, 1, 1);
    }
}
