package leetcodehot100_0309.第35题LRU缓存;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    int size = 0;
    Map<Integer, DListNode> map;
    DListNode head;
    DListNode tail;
    class DListNode{
        int key, value;
        DListNode pre, next;
        public DListNode(){}
        public DListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    public LRUCache(int capacity){
        map = new HashMap<>();
        this.capacity = capacity;
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.pre = head;
    }
    void put(int key, int value){
        DListNode node = map.get(key);
        if(node != null){
            node.value = value;
            moveToHead(node);
        }
        else {
            DListNode newNode = new DListNode();
            addToHead(newNode);
            size++;
            if(size > capacity){
                DListNode tail = removeTail();
                map.remove(tail.key);
            }
        }
    }
    int get(int key){
        DListNode node = map.get(key);
        if(node == null) return -1;
        else {
            moveToHead(node);
            return node.value;
        }
    }

    void addToHead(DListNode node){
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }
    void remove(DListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    void moveToHead(DListNode node){
        addToHead(node);
        remove(node);
    }
    DListNode removeTail(){
        DListNode node = tail.pre;
        remove(node);
        return node;
    }
}
