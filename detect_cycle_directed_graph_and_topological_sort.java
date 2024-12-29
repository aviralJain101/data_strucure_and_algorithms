import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean dfs(int node, boolean[] vis, boolean[] recStack, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        recStack[node] = true;
        for(int it: adj.get(node)){
            if(!vis[it]){
                if(dfs(it, vis, recStack, adj)){
                    return true;
                }
            }else if(recStack[it]){
                return true;
            }
        }
        recStack[node] = false;
        return false;
    }
  
    public boolean is_cyclic_using_dfs(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V];
        boolean[] recStack = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i, vis, recStack, adj)){
                    return true;
                }
            }
        }
        return false;
    }
  
    
    public boolean is_cyclic_using_bfs_topological_sort(int V, ArrayList<ArrayList<Integer>> adj){
        int[] inDeg = new int[V];
        ArrayList<Integer> topoSort=new ArrayList<>();
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                inDeg[adj.get(i).get(j)]++;
            }
        }
        ArrayDeque<Integer> q=new ArrayDeque();
        for(int i=0;i<V;i++){
            if(inDeg[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int u=q.poll();
            topoSort.add(u);
            for(int v:adj.get(u)){
                inDeg[v]--;
                if(inDeg[v]==0) q.add(v);
            }
        }
        if(topoSort.size()!=V) return true;
        return false;
    }
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        return is_cyclic_using_bfs_topological_sort(V, adj);
    }
}
