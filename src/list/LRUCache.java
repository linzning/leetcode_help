package list;

import java.util.HashMap;

public class LRUCache {
    static class Node{
        int key;
        int value;
        Node prev,next;
        Node(int _key,int _value){
            key=_key;
            value=_value;
            prev=next=null;
        }
    }
    private final Node dummy;
    private final int capacity;
    private int size;
    private final HashMap<Integer,Node>map;
    LRUCache(int _capacity){
        capacity=_capacity;
        size=0;
        dummy= new Node(-1, -1);
        dummy.prev=dummy;
        dummy.next=dummy;
        map=new HashMap<>();
    }
    int get(int key){
        if(map.containsKey(key)){
            Node cur=map.get(key);
            moveToHead(cur);
            return cur.value;
        }
        return -1;
    }
    void put(int key,int value){
        if(map.containsKey(key)){
            Node cur=map.get(key);
            cur.value=value;
            moveToHead(cur);
        }
        else {
            if(size==capacity){
                Node tail=removeTail();
                map.remove(tail.key);
                --size;
            }
            Node cur= new Node(key, value);
            addToHead(cur);
            map.put(key,cur);
            ++size;
        }
    }

    private void moveToHead(Node cur){
        removeNode(cur);
        addToHead(cur);
    }

    private void removeNode(Node cur){
        cur.prev.next=cur.next;
        cur.next.prev=cur.prev;
    }
    private void addToHead(Node cur){
        cur.next=dummy.next;
        cur.next.prev=cur;
        dummy.next=cur;
        cur.prev=dummy;
    }

    private Node removeTail(){
        Node cur=dummy.prev;
        removeNode(cur);
        return cur;
    }

}
