package leetcode148;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        quicksort(head,null);
        return head;
    }


    // 快排
    public void quicksort(ListNode head,ListNode tail){
        // 长度不为空且长度不为1
        if(head!=tail&&head.next!=tail){
            ListNode pivot=partition(head,tail);
            quicksort(head,pivot);
            quicksort(pivot.next,tail);
        }
    }

    public ListNode partition(ListNode left,ListNode right){
        int pivot=left.val;
        ListNode i=left;
        for(ListNode j=left.next;j!=right;j=j.next){
            if(j.val<pivot){
                swap(i, j);
                i=i.next;
            }
        }
        swap(left,i);
        return i;
    }

    public void swap(ListNode i,ListNode j){
        int temp=i.val;
        i.val=j.val;
        j.val=temp;
    }


    // 归并
    public ListNode mergeSort(ListNode head) {

        ListNode fast=head,slow=head;
        // 找到中间节点
        while (fast != null && fast.next != null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        // 归并head到slow 即前半部分
        ListNode l1=mergeSort(head);
        // 归并slow到tail 即后半部分
        ListNode l2=mergeSort(slow);

        return merge(l1, l2);
    }

    // 归并两个链表
    public ListNode merge(ListNode head1,ListNode head2){
        return null;
    }







}