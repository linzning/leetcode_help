package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructGraph {
    //无向图
    public static List<Integer>[] get_graph_binary(int n, int[][]edges){
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph,e->new ArrayList<>());
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }

    //[a,b]表示a->b
    public static List<Integer>[] get_graph_single(int n, int[][]edges){
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph,e->new ArrayList<>());
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        return graph;
    }

    //[a,b]表示b->a
    public static List<Integer>[] get_graph_single_pre(int n, int[][]edges){
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph,e->new ArrayList<>());
        for (int[] edge : edges) {
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }
}
