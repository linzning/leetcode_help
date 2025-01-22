package tree.nomaltree;

import tree.binarytree.TreeNode;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Construct {
    /**
     * 给定边构建无向树，其实就是无向图的构建
     * @param n
     * @param edges
     * @return
     */
    public List<Integer>[] getTree(int n, int[][]edges){
        List<Integer>[]graph=new List[n];
        Arrays.setAll(graph, e->new ArrayList<>());
        //graph[0].add(-1);
        for(int[]e:edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        return graph;
    }

    /**
     * 给定父节点数组构建有向树
     * @param n
     * @param parent
     * @return
     */
    public List<Integer>[] getTreeFromPa(int n,int[]parent){
        List<Integer>[]graph=new List[n];
        Arrays.setAll(graph,e->new ArrayList<>());
        for(int i=1;i<n;i++){
            graph[parent[i]].add(i);
        }
        return graph;
    }

    /**
     * 给定边构建带权无向树
     * @param n
     * @param edges
     * @return
     */
    public List<int[]>[] getTree_weight(int n,int[][]edges){
        List<int[]>[]graph=new List[n];
        Arrays.setAll(graph,e->new ArrayList<>());
        //graph[0].add(new int[]{-1,Integer.MIN_VALUE});可以减少是否是叶子的特判
        for(int[]e:edges){
            graph[e[0]].add(new int[]{e[1],e[2]});
            graph[e[1]].add(new int[]{e[0],e[2]});
        }
        return graph;
    }

    /**
     * 从二叉树构建一般树
     * @param root
     * @return
     */
    public HashMap<TreeNode,List<TreeNode>> constructNormalTreeFromBiTree(TreeNode root){
        HashMap<TreeNode,List<TreeNode>>graph=new HashMap<>();
        _constructNormalTreeFromBiTree(root,graph);
        return graph;
    }
    private void _constructNormalTreeFromBiTree(TreeNode root,HashMap<TreeNode,List<TreeNode>>graph){
        if(root==null)return;
        graph.putIfAbsent(root,new ArrayList<>());
        if(root.left!=null){
            graph.putIfAbsent(root.left,new ArrayList<>());
            graph.get(root).add(root.left);
            graph.get(root.left).add(root);
            _constructNormalTreeFromBiTree(root.left,graph);
        }
        if(root.right!=null){
            graph.putIfAbsent(root.right,new ArrayList<>());
            graph.get(root).add(root.right);
            graph.get(root.right).add(root);
            _constructNormalTreeFromBiTree(root.right,graph);
        }
    }

//    public HashMap<Integer,List<Integer>> constructNormalTreeFromBiTree(TreeNode root){
//        HashMap<Integer,List<Integer>>graph=new HashMap<>();
//        _constructNormalTreeFromBiTree(root,graph);
//        return graph;
//    }
//    private void _constructNormalTreeFromBiTree(TreeNode root,HashMap<Integer,List<Integer>>graph){
//        if(root==null)return;
//        graph.putIfAbsent(root.val,new ArrayList<>());
//        if(root.left!=null){
//            graph.putIfAbsent(root.left.val,new ArrayList<>());
//            graph.get(root.val).add(root.left.val);
//            graph.get(root.left.val).add(root.val);
//            _constructNormalTreeFromBiTree(root.left,graph);
//        }
//        if(root.right!=null){
//            graph.putIfAbsent(root.right.val,new ArrayList<>());
//            graph.get(root.val).add(root.right.val);
//            graph.get(root.right.val).add(root.val);
//            _constructNormalTreeFromBiTree(root.right,graph);
//        }
//    }
}
