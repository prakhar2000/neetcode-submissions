class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] vis = new boolean[n];
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            l.get(edge[0]).add(edge[1]);
            l.get(edge[1]).add(edge[0]);
        }

        int c = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(l, vis, i);
                c++;
            }
        }
        return c;
    }

    public void dfs(List<List<Integer>> l, boolean[] vis, int src) {
        vis[src] = true;

        for (int nei : l.get(src)) {
            if (!vis[nei])
                dfs(l, vis, nei);
        }
    }
}
