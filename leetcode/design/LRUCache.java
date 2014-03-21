package design;
/*
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.

 * get(key) - Get the value (will always be positive) of the key if the
              key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. 
              When the cache reached its capacity, it should invalidate the least 
              recently used item before inserting a new item.
 * */
import java.util.HashMap;

public class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    
    class NodeList {
        Node head;
        Node tail;
        public NodeList(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
    }
    
    private HashMap<Integer, Node> cache;
    private NodeList list;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.cache = new HashMap<Integer, Node>();
        this.list = new NodeList(null, null);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            // Whether it is the head
            if (node.prev != null) {
                // Two steps here before set the new head
                node.prev.next = node.next;
                // Whether it is the tail
                if (node.next == null) 
                    list.tail = node.prev;
                else
                    node.next.prev = node.prev;
                // Put it at the front, 4 steps !!!
                list.head.prev = node;
                node.next = list.head;
                node.prev = null;
                list.head = node;
                
                //cache.put(key, node);
            } 
            
            return node.val;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            
            if (node.prev != null) {
                // Two steps here before set the new head
                node.prev.next = node.next;
                // Whether it is the tail
                if (node.next == null) 
                    list.tail = node.prev;
                else
                    node.next.prev = node.prev;
                
                // Put it at the front, 4 steps
                list.head.prev = node;
                node.next = list.head;
                node.prev = null;
                list.head = node;
            }
        } else {
            Node node = new Node(key, value, null, null);
            if (size < capacity) {
                if (list.head == null && list.tail == null) {
                    list.head = node;
                    list.tail = node;
                } else {
                    // Put it at the front, 4 steps
                    list.head.prev = node;
                    node.next = list.head;
                    node.prev = null;
                    list.head = node;
                }
                cache.put(key, node);
                size++;
            } else {
                Node prev = list.tail.prev;
                cache.remove(list.tail.key);
                if (prev != null) {
                    list.tail = prev;
                    list.tail.next = null;
                    
                    // Put it at the front, 4 steps
                    list.head.prev = node;
                    node.next = list.head;
                    node.prev = null;
                    list.head = node;
                } else {
                    list.head = node;
                    list.tail = node;
                }
                cache.put(key, node);
            }
        }
    }
    
    public static void main(String args[]) {
        LRUCache lrucache = new LRUCache(3);
        lrucache.set(1, 1);
        lrucache.set(2, 2);
        lrucache.set(3, 3);
        lrucache.set(4, 4);
        System.out.println(lrucache.get(4));
        System.out.println(lrucache.get(3));
        System.out.println(lrucache.get(2));
        System.out.println(lrucache.get(1));
        lrucache.set(5, 5);
        System.out.println(lrucache.get(1));
        System.out.println(lrucache.get(2));
        System.out.println(lrucache.get(3));
        System.out.println(lrucache.get(4));
        System.out.println(lrucache.get(5));
        //lrucache.set(3, 2);
        //lrucache.set(4, 1);
        //System.out.println(lrucache.get(2));
        //System.out.println(lrucache.get(3));
    }
}