package graph;

import java.util.List;

public class DFS {
    /**
     * 有向图，从各点开始能到达的点数
     * @param n
     * @param graph
     * @return
     */
    public static int[] getBlockSize(int n, List<Integer>[]graph){
        int[]ans=new int[n];
        for(int i=0;i<n;i++){
            boolean[]isVis=new boolean[n];
            ans[i]=getBlockSizeDFS(i,isVis,graph);
        }
        return ans;
    }
    private static int getBlockSizeDFS(int i,boolean[]isVis,List<Integer>[]graph){
        isVis[i]=true;
        int ans=1;
        for(int next:graph[i]){
            if(!isVis[next]){
                ans+=getBlockSizeDFS(next,isVis,graph);
            }
        }
        return ans;
    }
}
