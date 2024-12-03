package linklist;

import java.util.HashMap;
import java.util.LinkedHashSet;


/**
 *
 * 每个键维护一个使用计数器 。使用计数最小的键是最久未使用的键。
 */
public class LFUCache {
    /**
     * 相同使用计数的键值集合
     */
    class Node{
        LinkedHashSet<Integer>set;
        int freq;
        Node prev;
        Node next;
        Node(int freq){
            this.freq=freq;
            set=new LinkedHashSet<>();
            prev=next=null;
        }
    }
    HashMap<Integer,Integer>valueMap;//键值map
    HashMap<Integer,Node>nodeMap;//键，node map
    Node dummy;
    int capacity;
    int size;
    LFUCache(int capacity){
        this.capacity=capacity;
        size=0;
        valueMap=new HashMap<>();
        nodeMap=new HashMap<>();
        dummy=new Node(-1);
        dummy.next=dummy;
        dummy.prev=dummy;
    }
    int get(int key){
        if(valueMap.containsKey(key)){
            Node cur=nodeMap.get(key);
            Node nextNode=cur.next;
            if(nextNode==dummy||nextNode.freq>cur.freq+1){
                //插入
                Node newNode=new Node(cur.freq+1);
                newNode.set.add(key);
                insertNode(cur,newNode,nextNode);
                nodeMap.put(key,newNode);
            }else if(nextNode.freq==cur.freq+1){
                //并入下一个
                nextNode.set.add(key);
                nodeMap.put(key,nextNode);
            }
            if(cur.set.size()==1){
                //删除该节点
                removeNode(cur);
            }else{
                cur.set.remove(key);
            }
            return valueMap.get(key);
        }
        return -1;
    }
    void put(int key,int value){
        if(valueMap.containsKey(key)){
            get(key);//只需修改valueMap,其余操作同get()
        }else{
            if(size==capacity){
                //删节点
                Node head=dummy.next;
                int dropKey=head.set.iterator().next();
                valueMap.remove(dropKey);
                head.set.remove(dropKey);
                if(head.set.isEmpty()){
                    removeNode(head);
                }
                nodeMap.remove(dropKey);
                --size;
            }
            if(dummy.next==dummy||dummy.next.freq>1){
                //插入
                Node newNode=new Node(1);
                newNode.set.add(key);
                insertNode(dummy,newNode,dummy.next);
                nodeMap.put(key,newNode);
            }else if(dummy.next.freq==1){
                dummy.next.set.add(key);
                nodeMap.put(key,dummy.next);
            }
            ++size;
        }
        valueMap.put(key,value);
    }
    void insertNode(Node cur, Node newNode, Node nextNode){
        newNode.next=nextNode;
        nextNode.prev=newNode;
        cur.next=newNode;
        newNode.prev=cur;
    }
    void removeNode(Node cur){
        cur.next.prev=cur.prev;
        cur.prev.next=cur.next;
    }
}
