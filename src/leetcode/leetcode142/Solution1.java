package leetcode.leetcode142;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Eivense
 * @date 2021/8/22 11:09 下午
 */
public class Solution1 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;

        ListNode slow = head;
        ListNode fast = head.next;
        // 循环结束即没有环
        while (fast != null && fast.next != null) {
            // 步长为1
            slow = slow.next;
            // 步长为2
            fast = fast.next.next;
            // 相遇则有环
            if (slow == fast) {
                while (temp != slow) {
                    temp=temp.next;
                    slow = slow.next;
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution1 solution=new Solution1();

        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(-4);

        listNode.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode1;

        System.out.println(solution.detectCycle(listNode).val);
    }
}
