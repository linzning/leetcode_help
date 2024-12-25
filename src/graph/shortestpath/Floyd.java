package graph.shortestpath;

import java.util.List;

public class Floyd {
    /**
     * 原地求最短路劲矩阵
     * @param n
     * @param graph 邻接矩阵对角线0，graph[i][j]=w,表示i->j权重为w,INF为max/3防止溢出
     * @return
     */
    public static void getShortestPathMatrix_floyd(int n, int[][]graph){
        int INF=Integer.MAX_VALUE/3;
        for(int p=0;p<n;p++){
            for(int i=0;i<n;i++){
                if(graph[i][p]==INF)continue;
                for(int j=0;j<n;j++){
                    graph[i][j]=Math.min(graph[i][j],graph[i][p]+graph[p][j]);
                }
            }
        }
    }

    /**
     * floyd支持加边的修改
     * @param n
     * @param graph
     * @param edge
     */
    public static void addEdge(int n,int[][]graph,int[]edge){
        int x=edge[0],y=edge[1],w=edge[2];
        if(w>graph[x][y])return;//无需更新
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                graph[i][j]=Math.min(graph[i][j],graph[i][x]+w+graph[y][j]);
            }
        }
    }
}
