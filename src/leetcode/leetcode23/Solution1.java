package leetcode.leetcode23;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Eivense
 * @date 2021/10/7 10:29 下午
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode listNode : lists) {
            ListNode head = listNode;
            while (head!= null) {
                priorityQueue.add(head);
                head = head.next;
            }
        }
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (!priorityQueue.isEmpty()) {
            head.next = priorityQueue.poll();
            head = head.next;
        }
        head.next = null;
        return temp.next;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode7 = new ListNode(2);
        ListNode listNode8 = new ListNode(6);
        listNode7.next = listNode8;

        solution.mergeKLists(new ListNode[]{listNode1, listNode4, listNode7});

    }
}
