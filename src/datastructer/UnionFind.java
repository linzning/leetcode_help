package datastructer;

import java.util.Arrays;

public class UnionFind {
    int[]parents;
    int[]size;
    int[]edges;
    public UnionFind(int n){
        parents=new int[n];
        size=new int[n];
        edges=new int[n];
        Arrays.fill(edges,0);
        Arrays.fill(size,1);
        for(int i=0;i<n;i++){
            parents[i]=i;
       }
    }

    public int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        //路径优化
        parents[x] = find(parents[x]);
        return parents[x];
    }
    //朴素合并
    public void merge(int i,int j){
        int x=find(i),y=find(j);
        parents[x]=y;
        size[y]+=size[x];
        edges[y]+=edges[x]+1;
    }
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
    public int getSize(int i){
        return size[i];
    }
    public int getedges(int i){
        return edges[i];
    }
}
