package datastructer;

import java.util.*;

/**
 * 并查集
 */
public class UnionFind {
    int[]parents;//记录每个元素的父节点
    int[]size;// 记录每个集合的大小
    int[]edges;// 记录每个集合边的大小
    int MAXN;

    /**
     * 初始化并查集
     * @param n 节点数目
     */
    public UnionFind(int n){
        MAXN=n;
        parents=new int[n];
        size=new int[n];
        edges=new int[n];
        Arrays.fill(edges,0);
        Arrays.fill(size,1);
        // 初始化时所有parent都是自己
        for(int i=0;i<n;i++){
            parents[i]=i;
       }
    }

    /**
     * 查找所属集合
     * @param x
     * @return
     */
    public int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        // 路径压缩优化
        parents[x] = find(parents[x]);
        return parents[x];
    }

    /**
     * 朴素合并,只能判断连通，其余都不行
     * @param i
     * @param j
     */
    public void merge(int i,int j){
        int x=find(i),y=find(j);
        parents[x]=y;
    }

    /**
     * 按集合大小合并
     * @param i
     * @param j
     */
    public void mergeBySize(int i,int j){
        int x=find(i),y=find(j);
        if(x==y){
            edges[x]++;
            return;
        }
        if(size[x]<size[y]){
            parents[x]=y;
            size[y]+=size[x];
            edges[y]+=edges[x]+1;
        }
        else{
            parents[y]=x;
            size[x]+=size[y];
            edges[x]+=edges[y]+1;
        }
    }
    public void mergeByEdges(int i,int j){
        int x=find(i),y=find(j);
        if(x==y){
            edges[x]++;
            return;
        }
        if(edges[x]<edges[y]){
            parents[x]=y;
            size[y]+=size[x];
            edges[y]+=edges[x]+1;
        }
        else{
            parents[y]=x;
            size[x]+=size[y];
            edges[x]+=edges[y]+1;
        }
    }

    /**
     * 获取集合的大小，注意：必须先调用find获取集合编号
     * @param i
     * @return
     */
    public int getSize(int i){
        return size[i];
    }
    public int getedges(int i){
        return edges[i];
    }

    /**
     * 求连通集个数
     * @return
     */
    public int countConnectedSet(){
        int[]count=new int[MAXN];
        int ans=0;
        for(int i=0;i<MAXN;i++){
            if(count[find(i)]++==0){
                ans++;
            }
        }
        return ans;
    }


    /**
     * 返回map的string  集合号->节点列表
     * @return
     */
    @Override
    public String toString(){
        HashMap<Integer, List<Integer>>map=new HashMap<>();//集合号->节点列表
        HashMap<Integer,Integer>mapSize=new HashMap<>();
        HashMap<Integer,Integer>mapEdges=new HashMap<>();
        for(int i=0;i<MAXN;i++){
            int setNum=find(i);
            List<Integer>nodeList=map.getOrDefault(setNum,new ArrayList<>());
            nodeList.add(i);
            map.put(setNum,nodeList);
            mapSize.put(setNum,getSize(setNum));
            mapEdges.put(setNum,getedges(setNum));
        }
        return map.toString()+mapSize.toString()+mapEdges.toString();
    }
}
