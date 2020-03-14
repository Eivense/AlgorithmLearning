package leetcode.leetcode23;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * 23. Merge k Sorted Lists
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 *
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        int n=lists.length;
        if(n==0){
            return null;
        }
        while(n>1){
            int k=(n+1)/2;
            for(int i=0;i<n/2;i++){
                lists[i]=merge(lists[i],lists[i+k]);
            }
            n=k;
        }
        return lists[0];
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        int n=lists.length;
        if(n==0){
            return null;
        }
        PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>(n, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val>o2.val)
                    return 1;
                else if(o1.val==o2.val)
                    return 0;
                else
                    return -1;
            }
        });
        for(ListNode node:lists){
            if(node!=null)
                queue.add(node);
        }

        ListNode temp=new ListNode(0);
        ListNode head=temp;
        while(!queue.isEmpty()){
            temp.next=queue.poll();
            temp=temp.next;
            if(temp.next!=null){
                queue.add(temp.next);
            }
        }
        return head.next;
    }



    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }


    public ListNode merge(ListNode list1,ListNode list2){
        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode temp=new ListNode(0);
        ListNode head=temp;

        while(list1!=null&&list2!=null){
            if(list1.val>list2.val){
                temp.next=list2;
                list2=list2.next;
            }else{
                temp.next=list1;
                list1=list1.next;
            }
            temp=temp.next;
        }

        // 如果list1已经走完了 直接接上剩下的list2
        if(list1==null){
            temp.next=list2;
        }else if (list2==null){
            temp.next=list1;
        }
        return head.next;
    }



}