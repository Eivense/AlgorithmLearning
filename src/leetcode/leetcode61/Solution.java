package leetcode.leetcode61;

/**
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * @author Eivense
 * @date 2021/3/27 3:37 下午
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        int step = length-k % length;
        if (step == length) {
            return head;
        }
        temp.next = head;
        while (step-- > 0) {
            temp = temp.next;
        }
        ListNode result = temp.next;
        temp.next = null;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotateRight(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))), 2);
    }
}
