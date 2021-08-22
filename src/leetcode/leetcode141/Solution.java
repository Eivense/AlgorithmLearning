package leetcode.leetcode141;

/**
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author Eivense
 * @date 2021/8/20 12:21 上午
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {

    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        // 慢指针
        ListNode index1=head;
        // 快指针
        ListNode index2=head.next;
        while(index1!=index2){
            // 快指针已经走到底了
            if(index2==null|| index2.next==null){
                return false;
            }
            index1=index1.next;
            index2=index2.next.next;
        }
        return true;
    }
}
