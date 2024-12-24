package graph;

import java.util.*;

public class TopologicalSort {
    int[]in;// 入度数组
    int N;// 节点数

    /**
     * 初始化入度数组
     * @param n 节点数
     * @param order 每个一维数组代表一个边
     * @param isPreorder preorder表示边的方向[a,b],preorder表示b->a
     */
    public TopologicalSort(int n,int[][]order,boolean isPreorder){
        N=n;
        in=new int[n];
        if(isPreorder){
            for(int[]pre:order){
                in[pre[0]]++;
            }
        }
        else{
            for(int[]pre:order){
                in[pre[1]]++;
            }
        }
    }

    /**
     * 得到拓扑排序的一种可能结果,带初始化节点
     * @param graph
     * @param init 初始提供的节点
     * @return 如成环则返回空list
     */
    public List<Integer> getOnePosibleOrder_init(List<Integer>[]graph,int[]init){
        // 0入度的节点队列
        Queue<Integer>zero_in=new LinkedList<>();
        for(int i:init){
            zero_in.offer(i);
        }
        List<Integer>ans=new LinkedList<>();
        while(!zero_in.isEmpty()){
            int cur=zero_in.poll();
            ans.add(cur);
            for(int nex:graph[cur]){
                if((--in[nex])==0){
                    zero_in.offer(nex);
                }
            }
        }
        return ans.size()==N?ans:new LinkedList<>();
    }

    /**
     * 得到拓扑排序的一种可能结果
     * @param graph
     * @return 如成环则返回空list
     */
    public List<Integer> getOnePosibleOrder(List<Integer>[]graph){
        // 0入度的节点队列
        Queue<Integer>zero_in=new LinkedList<>();
        for(int i=0;i<N;i++){
            if(in[i]==0)zero_in.offer(i);
        }
        List<Integer>ans=new LinkedList<>();
        while(!zero_in.isEmpty()){
            int cur=zero_in.poll();
            ans.add(cur);
            for(int nex:graph[cur]){
                if((--in[nex])==0){
                    zero_in.offer(nex);
                }
            }
        }
        return ans.size()==N?ans:new LinkedList<>();
    }

    /**
     * 得到工序层级，也就是连通无环图树的高度,注意：这个函数没经过测试,并且树的话的话所有节点的入度都应该为1
     * woc超级傻逼，这tm就是一个求树的高度，无语了
     * @param graph
     * @return
     */
    @Deprecated
    public int getLevel(List<Integer>[]graph,int root){
        Queue<Integer>zero_in=new LinkedList<>();
        zero_in.offer(root);
        int height=0;
        while (!zero_in.isEmpty()){
            int size=zero_in.size();
            while (size>0){
                int cur=zero_in.poll();
                for(int nex:graph[cur]){
                    if((--in[nex])==0){
                        zero_in.offer(nex);
                    }
                }
                size--;
            }
            height++;
        }
        return height;
    }

    /**
     * 得到各个节点的前驱节点，注意不是直接前驱，而是说需要做当前任务，前面所有需要完成的任务
     * @param graph 链式前向星建图
     * @return set数组
     */
    public HashSet<Integer>[] getPreNode(List<Integer>[]graph){
        HashSet<Integer>[]anc=new HashSet[N];
        Arrays.setAll(anc,e->new HashSet<>());
        Queue<Integer>zero_in=new LinkedList<>();
        for(int i=0;i<N;i++){
            if(in[i]==0)zero_in.offer(i);
        }
        while(!zero_in.isEmpty()){
            int cur=zero_in.poll();
            // 对每个nex节点,把cur加入它的前驱节点集
            for(int nex:graph[cur]){
                // 更新祖先hash表
                anc[nex].add(cur);
                // cur节点的前驱同样也是nex的前驱
                for(int a:anc[cur]){
                    anc[nex].add(a);
                }
                if((--in[nex])==0){
                    zero_in.offer(nex);
                }
            }
        }
        //List<List<Integer>>ans= Arrays.stream(anc).map(ArrayList::new).collect(Collectors.toList());
        return anc;
    }

    /**
     * 返回入度数组
     * @return
     */
    public int[] getIN(){
        return in;
    }
}
