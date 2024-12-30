package graph.MST;

import datastructer.UnionFind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Krustral {
    List<int[]>edges;//边集,[边编号,a,b,dist(a,b)]
    int N;//节点数量
    public Krustral(int n,List<int[]>_edges){
        edges=_edges;
        N=n;
    }

    /**
     * 求最小生成树
     * @return 返回的是用到的边的编号集合
     */
    public List<Integer> getMST(){
        UnionFind uf=new UnionFind(N);
        Collections.sort(edges,(a,b)->a[3]-b[3]);
        List<Integer>ans=new ArrayList<>();
        // 按权值大小从小到大遍历边
        for(int[]edge:edges){
            int a=edge[1],b=edge[2];
            if(uf.find(a)==uf.find(b))continue;
            uf.merge(a,b);
            ans.add(edge[0]);
        }
        return ans;
    }
}
