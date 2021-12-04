package leetcode.leetcode19;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author Eivense
 * @date 2021/9/25 3:40 下午
 */

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int temp=search(head, n);
        if (temp == n-1) {
            return head.next;
        }
        return head;
    }

    public int search(ListNode head,int target) {
        if (head.next== null) {
            return 0;
        }
        int n = search(head.next,target) + 1;
        if (n == target) {
            head.next = head.next.next;
        }
        return n;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next=listNode2;
//        listNode2.next=listNode3;
//        listNode3.next=listNode4;
//        listNode4.next=listNode5;

        solution.removeNthFromEnd(listNode1, 2);

    }

}
