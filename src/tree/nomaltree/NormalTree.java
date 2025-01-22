package tree.nomaltree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NormalTree {


    /**
     * dfs遍历无向树
     * @param graph
     */
    public void travel(List<Integer>[]graph){
        travel_dfs(0,-1,graph);
    }
    private void travel_dfs(int cur,int fa,List<Integer>[] graph){
        //process
        for(int nex:graph[cur]){
            //不能遍历回父节点
            if(nex!=fa){
                travel_dfs(nex,cur,graph);
            }
        }
    }
}
