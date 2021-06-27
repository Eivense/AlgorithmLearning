package offer.offer24;

/**
 * 剑指 Offer 24. 反转链表
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * @author Eivense
 * @date 2021/3/29 9:25 下午
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current=head;
        ListNode preivous=null;
        while (current!= null) {
            ListNode next = current.next;
            current.next=preivous;
            preivous=current;
            current=next;
        }
        return preivous;
    }
}
