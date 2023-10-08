package datastructure.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (map.size() == capacity)
            remove(tail.pre);
        if (map.containsKey(key))
            remove(map.get(key));
        insert(new Node(key, value));
    }

    private void insert(Node node) {
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.pre = head;
        node.next = headNext;
        headNext.pre = node;
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    class Node {
        int key, value;
        Node pre, next;

        public Node(int key, int val) {
            this.key = key;
            this.value = val;
            this.pre = null;
            this.next = null;
        }
    }
}
