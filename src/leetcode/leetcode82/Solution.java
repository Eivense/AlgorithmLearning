package leetcode.leetcode82;

/**
 * 82. Remove Duplicates from Sorted List II
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 *
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        ListNode temp=new ListNode(0,head);
        ListNode result=temp;
        while(temp.next!=null){
            ListNode current=temp.next;
            while(current.next!=null&&current.val==current.next.val){
                current=current.next;
            }
            // 是否和当前节点是同一节点
            if(current!=temp.next)
                // 不相等说明中间有相同的节点
                temp.next=current.next;
            else
                temp=temp.next;
        }
        return result.next;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        Solution solution = new Solution();

        solution.deleteDuplicates(head);
    }

}
