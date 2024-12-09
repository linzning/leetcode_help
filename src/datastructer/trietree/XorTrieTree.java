package datastructer.trietree;

public class XorTrieTree {
    class TrieNode{
        int n;
        TrieNode[]tns=new TrieNode[2];
    }
    TrieNode root=new TrieNode();
    void insert(int num){
        TrieNode p=root;
        for(int i=31;i>=0;--i){
            int c=(num>>i)&1;
            if(p.tns[c]==null)p.tns[c]=new TrieNode();
            p=p.tns[c];
        }
        p.n=num;
    }
    int find_max(int x){// 找到与x异或最大的那个数,返回抑或后值
        TrieNode p=root;
        for(int i=31;i>=0;--i){
            int c=(x>>i)&1;
            if(p.tns[c^1]!=null)p=p.tns[c^1];//优先走不同的一侧
            else p=p.tns[c];
        }
        return x^p.n;
    }
    public int findMaximumXOR(int[] nums) {
        int max=0;
        for (int n:nums){
            insert(n);
            max=Math.max(find_max(n),max);
        }
        return max;
    }
}
