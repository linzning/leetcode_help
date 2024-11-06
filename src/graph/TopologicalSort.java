package graph;

import java.util.*;

public class TopologicalSort {
    int[]in;
    int N;
    //preorder表示边的方向[a,b],preorder表示b->a
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

    public int[] getIN(){
        return in;
    }

    //如成环则返回空list
    public List<Integer> getOnePosibleOrder(List<Integer>[]graph){
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

    //获得先序节点
    public HashSet<Integer>[] getPreNode(List<Integer>[]graph){
        HashSet<Integer>[]anc=new HashSet[N];
        Arrays.setAll(anc,e->new HashSet<>());
        Queue<Integer>zero_in=new LinkedList<>();
        for(int i=0;i<N;i++){
            if(in[i]==0)zero_in.offer(i);
        }
        while(!zero_in.isEmpty()){
            int cur=zero_in.poll();
            for(int nex:graph[cur]){
                //更新祖先hash表
                anc[nex].add(cur);
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

}
