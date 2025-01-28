package tree.nomaltree;

import java.lang.annotation.Target;
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

    int maxDiameter;
    /**
     * 求树的直径
     *
     * 树形 DP 求直径。枚举子树 x 的所有子树 y，维护从 x 出发的最长路径 maxLen，
     * 那么可以更新答案为从 y 出发的最长路径加上 maxLen，再加上 nex[1]（边 x−y），即合并从 x 出发的两条路径。
     * 递归结束时返回 maxLen。
     *
     * @param graph
     * @return
     */
    public int getTreeDiameter(List<int[]>[]graph){
        maxDiameter=0;
        getTreeDiameter_dfs(0,-1,graph);
        return maxDiameter;
    }
    //返回当前节点向下的最长路径
    int getTreeDiameter_dfs(int cur,int fa,List<int[]>[]graph){
        int maxLen=0;
        for(int[]nex:graph[cur]){
            if(nex[0]!=fa){
                int subLen=getTreeDiameter_dfs(nex[0],cur,graph)+nex[1];
                maxDiameter=Math.max(maxDiameter,maxLen+subLen);//左侧子树的最长链长和当前子树的链长，和直径取max
                maxLen=Math.max(maxLen,subLen);//maxlen是所有左侧子树的最长链长
            }
        }
        return maxLen;
    }
}
