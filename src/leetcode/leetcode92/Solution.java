package leetcode.leetcode92;

/**
 * 92. 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 *
 * @author Eivense
 * @date 2021/9/23 10:57 下午
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode tempHead = result;

        for (int i = 0; i < left-1; i++) {
            tempHead = tempHead.next;
        }
        // 左节点前一个节点 模拟的头部
        ListNode current = tempHead.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = current.next;
            current.next=next.next;
            next.next=tempHead.next;
            tempHead.next = next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next = listNode4;

        solution.reverseBetween(listNode, 2, 4);
    }
}
