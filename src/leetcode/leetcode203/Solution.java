package leetcode.leetcode203;

import javax.sound.midi.Soundbank;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * @author Eivense
 * @date 2021/3/26 10:33 下午
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(0, head);
        ListNode result = newHead;
        ListNode prev = result;
        ListNode current = head;
        while (current!= null) {
            ListNode next = current.next;
            if (current.val == val) {
                prev.next = next;
            }else{
                prev = prev.next;
            }
            current = next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.removeElements(new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))), 6);
    }
}
