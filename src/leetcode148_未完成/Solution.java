package leetcode148_未完成;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
return null;
    }


    public void quicksort(ListNode head,ListNode end){
        if(head!=end){
            ListNode pivot=partition(head);
            quicksort(head,pivot);
            quicksort(pivot.next,end);
        }
    }

    public ListNode partition(ListNode head){
        return null;
    }


}