package leetcode.leetcode143;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 143. 重排链表
 * https://leetcode-cn.com/problems/reorder-list/
 *
 * @author Eivense
 * @date 2021/9/25 12:25 上午
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

    public void reorderList(ListNode head) {
        ListNode newHead = new ListNode();
        newHead.next=head;
        // 找到中间节点
        ListNode slow = newHead;
        ListNode fast = newHead;
        // 一半节点的个数
        int num = 0;
        while (fast!=null&&fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            num++;
        }

        // 后半指针倒叙
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode mid = slow.next;
        while (mid != null) {
            ListNode next = mid.next;
            mid.next=null;
            stack.push(mid);
            mid = next;
        }

        ListNode temp = head;
        for (int i = 0; i < num-1; i++) {
            if(stack.isEmpty()){
                continue;
            }
            ListNode next = temp.next;
            ListNode node = stack.pop();
            temp.next = node;
            node.next = next;
            temp = next;
        }
        temp.next = null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;

        Solution solution = new Solution();
        solution.reorderList(listNode1);

    }
}
