class Solution {
    private boolean dfs(int[][] g, int u, int c, int[] color){
        color[u]=c;
        for(int v: g[u]){
            if(color[v] == -1){
                if(!dfs(g, v, 1-c, color)) return false;
            }else if(color[v]==c) return false;
        }
        return true;
    }
    private boolean dfs_is_bipartite(int[][] g){
        int V=g.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for(int i=0;i<V;i++){
            if(color[i] == -1){
                if(!dfs(g, i, 0, color)) return false;
            }
        }
        return true;
    }
    
    private boolean bfs_is_bipartite(int[][] g){
        int V=g.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                q.add(i);
                color[i] = 0;
                while(!q.isEmpty()){
                    int u = q.poll();
                    for(int v: g[u]){
                        if(color[v]==-1){
                            color[v] = 1-color[u];
                            q.add(v);
                        }else if(color[v]==color[u]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] g) {
        return dfs_is_bipartite(g);
    }
}
