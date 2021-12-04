package leetcode.leetcode146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eivense
 * @date 2021/9/24 11:38 下午
 */
public class LRUCache1 {


    private int capacity;

    private NodeList nodeList;

    private Map<Integer, Node> map;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        nodeList = new NodeList();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // 最近操作过
            nodeList.moveHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node newNode = new Node(key,value);
        if (map.containsKey(key)) {
            Node node = map.get(key);
            nodeList.remove(node);
        }else{
            // 满了删除最老的
            if (map.size() == capacity) {
                Node last = nodeList.removeLast();
                map.remove(last.key);
            }
        }
        map.put(key, newNode);
        nodeList.add(newNode);
    }


}

class Node {

    public int val;

    public int key;
    public Node next;

    public Node prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}


class NodeList {

    Node head;
    Node tail;

    NodeList() {
        // 虚拟头结点
        head = new Node(0, 0);
        tail = new Node(0, 0);

        // 初始化头尾节点
        head.next = tail;
        tail.prev = head;
    }

    // 头插
    public void add(Node node) {
        Node next = head.next;
        node.next = next;
        head.next = node;
        next.prev = node;
        node.prev = head;
    }

    // 把最近使用的移动到头
    public void moveHead(Node node) {
        // 先删除该节点
        remove(node);
        // 插到头
        add(node);
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public Node removeLast() {
        Node last = tail.prev;
        remove(last);
        return last;
    }


    public static void main(String[] args) {
        LRUCache1 lruCache1 = new LRUCache1(2);
        lruCache1.get(2);
        lruCache1.put(2,6);
        lruCache1.get(1);
        lruCache1.put(1, 5);
        lruCache1.put(1, 2);
        lruCache1.get(1);
        lruCache1.get(2);
    }
}

