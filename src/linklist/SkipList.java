package linklist;


import java.util.Arrays;
import java.util.Random;

/**
 * https://oi-wiki.org/ds/skiplist/
 */

/**
 * skiplist的一种实现
 */
public class SkipList {
    class Node {
        int val;
        int level;
        Node[]next;
        int[]span;//next指针的跨度
        Node (int val,int l) {
            this.val = val;
            this.level=l;
            next=new Node[l+1];
            span=new int[l+1];
        }
    }
    private static final int MAX_LEVEL=32;
    private static final int P=2;
    Random random;
    Node head;
    Node tail;
    int size;
    int level;
    public SkipList() {
        random=new Random();
        size=0;
        level=0;
        tail=new Node(Integer.MAX_VALUE,MAX_LEVEL-1);
        head=new Node(-1,MAX_LEVEL-1);
        for(int i=0;i<MAX_LEVEL;i++)head.next[i]=tail;
    }

    /**
     * 新加入节点的层数
     * @return int 层数
     */
    int randomLevel() {
        int lv = 0;//初始是第一层
        while (random.nextInt(P)==0) ++lv;//每个位于第 i 层的节点有 p 的概率出现在第 i+1 层
        return Math.min(MAX_LEVEL-1, lv);
    }

    /**
     * 查找节点
     * @param target
     * @return 找到返回true
     */
    public boolean search(int target) {
        Node p=head;
        for(int i=level;i>=0;i--){
            while (p.next[i].val<target){
                p=p.next[i];
            }
        }
        return p.next[0].val == target;
    }

    /**
     * 找到前序节点
     * @param num
     * @param prev
     */
    void findPrev(int num,Node[]prev){
        Node p=head;
        for(int i=level;i>=0;i--){
            while(p.next[i].val<num){
                p=p.next[i];
            }
            prev[i]=p;
        }
    }

    public void add(int num) {
        Node[]update=new Node[MAX_LEVEL];//需要修改next指针的节点
        int[]pos=new int[MAX_LEVEL];//
        Node p=head;
        for(int i=level;i>=0;i--){
            pos[i]=i==level?0:pos[i+1];
            while(p.next[i].val<num){
                pos[i]+=p.span[i];
                p=p.next[i];
            }
            update[i]=p;
        }
        int lv=randomLevel();
        if(lv>level){
            lv=++level;
            update[lv]=head;
            pos[lv]=0;
        }
        Node newNode=new Node(num,lv);
        for(int i=lv;i>=0;i--){
            p=update[i];
            //插入链表
            newNode.next[i]=p.next[i];
            newNode.span[i]=p.span[i]-(pos[0]-pos[i]);
            p.next[i]=newNode;
            p.span[i]=pos[0]-pos[i]+1;
        }
        for(int i=lv+1;i<=level;i++){
            update[i].span[i]++;
        }
        ++size;
    }

    public boolean erase(int num) {
        Node[]update=new Node[MAX_LEVEL];
        Node p=head;
        for(int i=level;i>=0;i--){
            while(p.next[i].val<num){
                p=p.next[i];
            }
            update[i]=p;
        }
        p=p.next[0];
        if(p.val!=num)return false;
        for(int i=0;i<=level;i++){
            if(update[i].next[i]==p){
                update[i].span[i]+=p.span[i]-1;
                update[i].next[i]=p.next[i];
            }else{
                update[i].span[i]--;
            }
        }
        while(level>0&&head.next[level]==tail)--level;
        --size;
        return true;
    }

    public int getPosbyKey(int key){
        Node p=head;
        int pos=0;
        for(int i=level;i>=0;i--){
            while(p.next[i].val<key){
                pos+=p.span[i];
                p=p.next[i];
            }
        }
        return pos;
    }

    public int getKeybyPos(int pos){
        pos=Math.min(pos+1,size);
        Node p=head;
        for(int i=level;i>=0;i--){
            while (p.next[i]!=tail&&pos-p.span[i]>0){
                pos-=p.span[i];
                p=p.next[i];
            }
        }
        return p.next[0].val;
    }

    public void print(){
        int[][]num=new int[level+1][size];
        Node p=head.next[0];
        int i=0;
        while(p!=tail){
            int lv=p.level;
            while(lv>=0){
                num[lv][i]=p.val;
                lv--;
            }
            p=p.next[0];
            i++;
        }
        for(i=level;i>=0;i--){
            System.out.print("level:"+i);
            System.out.println(Arrays.toString(num[i]));
        }
    }
}
