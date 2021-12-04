package leetcode.leetcode160;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Eivense
 * @date 2021/9/24 11:04 下午
 */
public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while (headA!= null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }else{
                headB = headB.next;
            }
        }
        return null;
    }
}
