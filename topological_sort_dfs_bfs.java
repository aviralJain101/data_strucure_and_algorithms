class Solution {
    // Function to return list containing vertices in Topological order.
    
    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> topoSort){
        vis[node]=true;
        for(int v: adj.get(node)){
            if(!vis[v]) dfs(v, adj, vis, topoSort);
        }
        topoSort.add(node);
    }
    
    static ArrayList<Integer> dfs_topological_sort(ArrayList<ArrayList<Integer>> adj){
        int V=adj.size();
        ArrayList<Integer> topoSort=new ArrayList();
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]) dfs(i, adj, vis, topoSort);
        }
        Collections.reverse(topoSort);
        return topoSort;
    }
    
    static ArrayList<Integer> bfs_topological_sort(ArrayList<ArrayList<Integer>> adj){
        int V=adj.size();
        ArrayList<Integer> topoSort=new ArrayList();
        int[] inDeg=new int[V];
        for(int i=0;i<V;i++){
            for(int j=0;j<adj.get(i).size();j++){
                inDeg[adj.get(i).get(j)]++;
            }
        }
        ArrayDeque<Integer> q=new ArrayDeque();
        for(int i=0;i<V;i++){
            if(inDeg[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int u=q.poll();
            topoSort.add(u);
            for(int v: adj.get(u)){
                inDeg[v]--;
                if(inDeg[v]==0) q.add(v);
            }
        }
        return topoSort;
    }
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        return dfs_topological_sort(adj);
    }
}
