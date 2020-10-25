package interview.interview02_02;


/**
 * 面试题 02.02. 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 *
 * 给定的 k 保证是有效的。
 *
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode p=head;
        ListNode q=head;
        while (k>1) {
            q=q.next;
            k--;
        }
        while (q.next != null) {
            p=p.next;
            q = q.next;
        }
        return p.val;
    }
}
