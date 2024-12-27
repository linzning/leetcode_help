package graph;

import java.util.*;

public class TopologicalSort {
    int[] in;// 入度数组
    int N;// 节点数

    /**
     * 初始化入度数组
     *
     * @param n          节点数
     * @param order      每个一维数组代表一个边
     * @param isPreorder preorder表示边的方向[a,b],preorder表示b->a
     */
    public TopologicalSort(int n, int[][] order, boolean isPreorder) {
        N = n;
        in = new int[n];
        if (isPreorder) {
            for (int[] pre : order) {
                in[pre[0]]++;
            }
        } else {
            for (int[] pre : order) {
                in[pre[1]]++;
            }
        }
    }

    /**
     * 得到拓扑排序的一种可能结果,带初始化节点
     *
     * @param graph
     * @param init  初始提供的节点
     * @return 如成环则返回空list
     */
    public List<Integer> getOnePosibleOrder_init(List<Integer>[] graph, int[] init) {
        // 0入度的节点队列
        Queue<Integer> zero_in = new LinkedList<>();
        for (int i : init) {
            zero_in.offer(i);
        }
        List<Integer> ans = new LinkedList<>();
        while (!zero_in.isEmpty()) {
            int cur = zero_in.poll();
            ans.add(cur);
            for (int nex : graph[cur]) {
                if ((--in[nex]) == 0) {
                    zero_in.offer(nex);
                }
            }
        }
        return ans.size() == N ? ans : new LinkedList<>();
    }

    /**
     * 得到拓扑排序的一种可能结果
     *
     * @param graph
     * @return 如成环则返回空list
     */
    public List<Integer> getOnePosibleOrder(List<Integer>[] graph) {
        // 0入度的节点队列
        Queue<Integer> zero_in = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (in[i] == 0) zero_in.offer(i);
        }
        List<Integer> ans = new LinkedList<>();
        while (!zero_in.isEmpty()) {
            int cur = zero_in.poll();
            ans.add(cur);
            for (int nex : graph[cur]) {
                if ((--in[nex]) == 0) {
                    zero_in.offer(nex);
                }
            }
        }
        return ans.size() == N ? ans : new LinkedList<>();
    }

    /**
     * 得到各个节点的前驱节点，注意不是直接前驱，而是说需要做当前任务，前面所有需要完成的任务
     *
     * @param graph 链式前向星建图
     * @return set数组
     */
    public HashSet<Integer>[] getPreNode(List<Integer>[] graph) {
        HashSet<Integer>[] anc = new HashSet[N];
        Arrays.setAll(anc, e -> new HashSet<>());
        Queue<Integer> zero_in = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (in[i] == 0) zero_in.offer(i);
        }
        while (!zero_in.isEmpty()) {
            int cur = zero_in.poll();
            // 对每个nex节点,把cur加入它的前驱节点集
            for (int nex : graph[cur]) {
                // 更新祖先hash表
                anc[nex].add(cur);
                // cur节点的前驱同样也是nex的前驱
                for (int a : anc[cur]) {
                    anc[nex].add(a);
                }
                if ((--in[nex]) == 0) {
                    zero_in.offer(nex);
                }
            }
        }
        //List<List<Integer>>ans= Arrays.stream(anc).map(ArrayList::new).collect(Collectors.toList());
        return anc;
    }

    /**
     * 求内向基环树中最长环的长度，内向（所有点出度为1），外向（所有点入度为1）
     * @param graph 下标指向值的边（一个点只有一个出边）
     * @return
     */
    public int getMaxRingSize(int[] graph) {
        Queue<Integer> zero_in = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (in[i] == 0) zero_in.offer(i);
        }
        //去除链
        while (!zero_in.isEmpty()) {
            int cur = zero_in.poll();
            int nex=graph[cur];
            if ((--in[nex]) == 0) {
                zero_in.offer(nex);
            }
        }
        int maxRingsSize = 0;
        for (int i = 0; i < N; i++) {
            if (in[i] == 0) continue;//不在环内
            in[i] = 0;// 将入度标为0，避免重复访问
            int ringSize = 1;
            for(int x=graph[i];x!=i;x=graph[x]){
                in[x]=0;//避免重复访问
                ringSize++;
            }
            maxRingsSize=Math.max(maxRingsSize,ringSize);
        }
        return maxRingsSize;
    }

    /**
     * 返回入度数组
     *
     * @return
     */
    public int[] getIN() {
        return in;
    }
}
