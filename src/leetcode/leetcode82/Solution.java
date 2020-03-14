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
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        ListNode temp=new ListNode(0);
        temp.next=head;

        ListNode result=temp;

        while(temp.next!=null){
            ListNode current=temp.next;
            while(current.next!=null&&current.val==current.next.val){
                current=current.next;
            }
            if(current!=temp.next)
                temp.next=current.next;
            else
                temp=temp.next;
        }
        return head;
    }

}
