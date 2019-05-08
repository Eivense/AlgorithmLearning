package leetcode21;


/**
 * 21. Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 *
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;

        ListNode temp=new ListNode(0);
        ListNode head=temp;

        while(l1!=null&&l2!=null){
            if(l1.val>l2.val){
                temp.next=l2;
                l2=l2.next;
            }else{
                temp.next=l1;
                l1=l1.next;
            }
            temp=temp.next;
        }
        if(l1==null){
            temp.next=l2;
        }else{
            temp.next=l1;
        }

        return head.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;

        if(l1.val>l2.val){
            l2.next=mergeTwoLists2(l1,l2.next);
            return l2;
        }else{
            l1.next=mergeTwoLists2(l1.next,l2);
            return l1;
        }
    }


    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(1);

        ListNode a=new ListNode(2);
        ListNode b=new ListNode(3);
        ListNode c=new ListNode(4);
        ListNode d=new ListNode(4);


        l1.next=a;
        a.next=c;

        l2.next=b;
        b.next=d;

        Solution solution=new Solution();
        solution.mergeTwoLists2(l1,l2);
    }
}
