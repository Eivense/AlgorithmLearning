package leetcode.leetcode234;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eivense
 * @date 2021/10/11 9:31 下午
 */
public class Solution1 {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int a=0;
        int b = list.size() - 1;
        while (a < b) {
            if (!list.get(a).equals(list.get(b))) {

                return false;
            } else {
                a++;
                b--;
            }
        }
        return true;
    }
}
