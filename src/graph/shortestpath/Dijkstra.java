package graph.shortestpath;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    /**
     * 求begin开始的单源最短路
     * @param n
     * @param graph
     * @return
     */
    public static int[] getShortestPath_dijkstra(int n,List<int[]>[]graph,int begin){
        int[]dist=new int[n];
        Arrays.fill(dist,-1);
        dist[begin]=0;
        //[点，距离],保存从现有集合出发到外界点的距离
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);//第二位升序
        pq.offer(new int[]{begin,0});
        while (!pq.isEmpty()){
            int[]cur=pq.poll();//出一个最短距离点
            int id=cur[0];
            int dx=cur[1];
            if(dx>dist[id])continue;//已经出过堆了
            for(int[]next:graph[id]){
                int next_id=next[0];
                int weight=next[1];
                int next_dis=dist[id]+weight;
                // 以这个最近点进行松弛操作
                if(dist[next_id]<0||dist[next_id]>next_dis){
                    dist[next_id]=next_dis;
                    pq.offer(new int[]{next_id,next_dis});
                }
            }
        }
        return dist;
    }

}
