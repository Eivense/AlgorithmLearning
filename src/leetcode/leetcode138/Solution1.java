package leetcode.leetcode138;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eivense
 * @date 2021/7/17 3:39 下午
 */
public class Solution1 {
    public Node copyRandomList(Node head) {
        Node oldHead = head;
        Map<Node, Node> map = new HashMap<>();
        while (head != null) {
            Node newNode = new Node(head.val);
            map.put(head, newNode);
            head = head.next;
        }

        for (Map.Entry<Node, Node> temp : map.entrySet()) {
            Node old = temp.getKey();
            Node clone = temp.getValue();
            clone.next = map.get(old.next);
            clone.random = map.get(old.random);
        }

        return map.get(oldHead);
    }
}
