package graph.MST;

import java.util.Arrays;
import java.util.List;

/**
 * 一般用于稠密图
 */
public class Prim {
    int[][] graph;
    int N;
    public Prim(int n,int[][] _graph){
        graph=_graph;
        N=n;
    }

    /**
     * 求最小生成树
     * @param start 初始加入到树中的节点
     * @return 返回生成树总权值
     */
    public int getMST(int start){
        // 记录 V 中的点到 Vnew 的最近距离
        int[] lowcost = new int[N];
        Arrays.fill(lowcost, Integer.MAX_VALUE);
        // 记录节点是否已经加入生成树
        boolean[] isIN = new boolean[N];
        isIN[start] = true;
        for (int i = 0; i < N; i++) {
            if (i == start) continue;
            lowcost[i] = graph[start][i];
        }

        int ans=0;
        int count=1;//已加入的节点
        while (count++<N){
            int minIdx = -1;
            int minVal = Integer.MAX_VALUE;
            //找出离现在的树最近的节点,因为用于稠密图所以直接简单遍历
            for(int i=0;i<N;i++){
                if(!isIN[i]&&lowcost[i]<minVal){
                    minIdx=i;
                    minVal=lowcost[i];
                }
            }
            //加入最近的点
            isIN[minIdx]=true;
            ans+=minVal;
            //更新lowcost
            for(int i=0;i<N;i++){
                if(!isIN[i]&&graph[minIdx][i]<lowcost[i]){
                    lowcost[i]=graph[minIdx][i];
                }
            }
        }
        return ans;
    }
}
