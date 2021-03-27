package leetcode.leetcode83;

/**
 * @author Eivense
 * @date 2021/3/26 9:54 下午
 */
public class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = head;
        while (head!= null) {
            ListNode current = head;
            // 找到不相等的节点
            while (current.next != null && current.val == current.next.val) {
                current.next = current.next.next;
            }
            head=current.next;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
