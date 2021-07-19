package leetcode.leetcode146;

import java.util.*;

/**
 * 146. LRU 缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 *
 * @author Eivense
 * @date 2021/7/17 4:27 下午
 */
public class LRUCache {

    private int capacity;

    private NodeList nodeList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeList = new NodeList(capacity);
    }

    public int get(int key) {
        return nodeList.get(key);
    }

    public void put(int key, int value) {
        nodeList.add(key, value);
    }
}


class Node{

    Integer key;

    Integer value;

    Node pre;

    Node next;

    Node() {

    }

    Node(int key,int value) {
        this.key = key;
        this.value = value;
    }
}


class NodeList{

    Node head;
    Node tail;

    int capacity;
    int size;

    Map<Integer, Node> map = new HashMap<>();

    public NodeList(int capacity){
        head = new Node();
        tail = new Node();
        this.capacity = capacity;

        head.next = tail;
        tail.pre = head;
    }


    public void add(int key,int value) {
        Node node=new Node(key,value);
        if (map.containsKey(key)) {
            remove(map.get(key));
            addFirst(node);
            map.put(key, node);
        }else{
            if (size == capacity) {
                map.remove(removeLast().key);
            }
            map.put(key, node);
            addFirst(node);
        }
    }

    public Node remove(Node node) {
        Node tempPre = node.pre;
        Node tempNext = node.next;
        tempPre.next = tempNext;
        tempNext.pre = tempPre;
        size--;
        return node;
    }

    public Node removeLast() {
        Node temp = tail.pre;
        tail.pre = tail.pre.pre;
        tail.pre.next = tail;

        size--;
        return temp;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            moveToHead(key);
            return map.get(key).value;
        }else{
            return -1;
        }
    }

    public void moveToHead(int key) {
        // 找到需要移到头的节点
        Node target = remove(map.get(key));
        // 把target插入到head后面
        addFirst(target);
    }

    public void addFirst(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre=node;
        head.next = node;
        size++;
    }
}