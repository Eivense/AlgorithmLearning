package offer.offer18;

/**
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 * @author Eivense
 * @date 2021/3/26 10:59 下午
 */
public class Solution {
    public ListNode deleteNode(ListNode head, int val) {


        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode result = newHead;

        ListNode prev = newHead;
        ListNode current = newHead.next;
        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
                break;
            }
            current = current.next;
            prev = prev.next;
        }
        return result.next;
    }
}
