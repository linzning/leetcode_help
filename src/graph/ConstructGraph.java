package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructGraph {
    /**
     * 构建带权重的无向图
     *
     * @param n
     * @param edges [u,v,weight]
     * @return
     */
    public static List<int[]>[] get_graph_binary_weight(int n, int[][] edges) {
        List<int[]>[] graph=new ArrayList[n];
        Arrays.setAll(graph ,e->new ArrayList<>());
        for(int[]edge:edges){
            int u=edge[0],v=edge[1],w=edge[2];
            graph[u].add(new int[]{v,w});
            graph[v].add(new int[]{u,w});
        }
        return graph;
    }

    /**
     * 构建带权重的有向图
     *
     * @param n
     * @param edges [u,v,weight] u->v
     * @return
     */
    public static List<int[]>[] get_graph_single_weight(int n, int[][] edges) {
        List<int[]>[] graph=new ArrayList[n];
        Arrays.setAll(graph ,e->new ArrayList<>());
        for(int[]edge:edges){
            int u=edge[0],v=edge[1],w=edge[2];
            graph[u].add(new int[]{v,w});
        }
        return graph;
    }

    /**
     * 从给定边构建无向图
     *
     * @param n     节点个数
     * @param edges 其中的一个数组表示一个边，节点编号0开始
     * @return 链式前向星，List<Integer>[]
     */
    public static List<Integer>[] get_graph_binary(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }

    /**
     * 构建有向图
     *
     * @param n     节点个数
     * @param edges
     * @return 链式前向星，List<Integer>[]
     */
    public static List<Integer>[] get_graph_single(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        return graph;
    }

    /**
     * 反向构建有向图
     *
     * @param n     节点个数
     * @param edges [a,b]表示b->a
     * @return
     */
    public static List<Integer>[] get_graph_single_pre(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for (int[] edge : edges) {
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }


    /**
     * 从带权值边构建无向邻接矩阵
     *
     * @param n
     * @param edges
     * @return
     */
    public static int[][] get_graph_matrix_single_weight(int n, int[][] edges) {
        int INF=Integer.MAX_VALUE/3;
        int[][] graph = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(graph[i],INF);
            graph[i][i]=0;
        }
        for (int[] e : edges) {
            graph[e[0]][e[1]] = e[2];
        }
        return graph;
    }
}
