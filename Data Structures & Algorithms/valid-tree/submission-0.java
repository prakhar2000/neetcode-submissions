class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        boolean[] vis = new boolean[n];
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            l.get(edge[0]).add(edge[1]);
            l.get(edge[1]).add(edge[0]);
        }

        if (hasCycle(0, -1, l, vis)) {
            return false;
        }

        for (boolean visited : vis) {
            if (!visited)
                return false;
        }

        return true;
    }
    public boolean hasCycle(int curr, int p, List<List<Integer>> l, boolean[] vis) {
        vis[curr] = true;

        for (int nei : l.get(curr)) {
            if (nei == p)
                continue;
            if (vis[nei])
                return true;
            if (hasCycle(nei, curr, l, vis))
                return true;
        }
        return false;
    }
}
