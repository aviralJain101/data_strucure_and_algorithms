class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean bfs(int V, ArrayList<ArrayList<Integer>> adj, int src, int[] parent){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(src);
        parent[src] = src;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i : adj.get(node)){
                if(parent[node] != i){
                    if(parent[i] != -1){
                        return true;
                    }else{
                        parent[i] = node;
                        q.add(i);
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] parent, int node){
        for(int i: adj.get(node)){
            if(parent[node] != i){
                if(parent[i] != -1) return true;
                else{
                    parent[i]=node;
                    if(dfs(adj, parent, i)) return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] parent=new int[V];
        Arrays.fill(parent, -1);
        for(int i=0;i<V;i++){
            if(parent[i] == -1){
                parent[i]=i;
                if(dfs(adj, parent,i)){
                    return true;
                }
            }
        }
        return false;
    }
}
