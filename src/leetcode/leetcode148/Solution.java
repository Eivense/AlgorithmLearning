package leetcode.leetcode148;


/**
 * 148. Sort List
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 */
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
//        quicksort(head,null);
        return mergeSort(head);
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
        if(head==null||head.next==null){
            return head;
        }

        ListNode mid = getMid(head);
        ListNode right=mid.next;
        // 断开链表
        mid.next=null;

        // 归并前半部分
        ListNode l1=mergeSort(head);
        // 归并后半部分
        ListNode l2=mergeSort(right);

        return merge(l1, l2);
    }

    private ListNode getMid(ListNode head){
        // 为空或者只有一个节点
        if(head==null||head.next==null){
            return head;
        }
        // 快慢指针
        ListNode fast=head,slow=head;
        // 找到中间节点
        while (fast.next!= null && fast.next.next!= null) {
            fast=fast.next.next;
            slow=slow.next;
        }

        return slow;
    }

    // 归并两个链表
    public ListNode merge(ListNode head1,ListNode head2){
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;

        ListNode newHead,p;
        if(head1.val>head2.val){
            newHead=head2;
            head2=head2.next;
        }else{
            newHead=head1;
            head1=head1.next;
        }
        p=newHead;
        while(head1!=null&&head2!=null){
            if(head1.val>head2.val){
                p.next=head2;
                head2=head2.next;
            }else{
                p.next=head1;
                head1=head1.next;
            }
            p=p.next;
        }

        if(head1!=null){
            p.next=head1;
        }
        if(head2!=null){
            p.next=head2;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(4);
        ListNode a=new ListNode(2);
        ListNode b=new ListNode(1);
        ListNode c=new ListNode(3);
//        ListNode d=new ListNode(4);
//        ListNode e=new ListNode(4);
//        ListNode f=new ListNode(4);


        l1.next=a;
        a.next=b;
        b.next=c;
//        c.next=e;
//        e.next=f;

        Solution solution = new Solution();
        solution.sortList(l1);
    }







}