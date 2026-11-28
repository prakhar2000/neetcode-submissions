class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            l.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            boolean[] vis = new boolean[n+1];

            if (!l.get(u).isEmpty() && !l.get(v).isEmpty() && dfs(l, u,v, vis)){
                return edges[i];

            }

            l.get(u).add(v);
            l.get(v).add(u);
        }

        return new int[0];
    }

    public boolean dfs(List<List<Integer>> l , int u, int v, boolean[] vis){
        if (u == v) return true;
        vis[u]= true;

        for(int nei: l.get(u)){
            if(!vis[nei]){
                if(dfs(l,nei,v,vis )){
                    return true;
                }
            }
        }
        return false;
    }
}
