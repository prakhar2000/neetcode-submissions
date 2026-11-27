class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            l.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            l.get(from).add(to);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] recPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (findCycle(l, i, vis, recPath)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean findCycle(List<List<Integer>> l, int src, boolean[] vis, boolean[] recPath) {
        vis[src] = true;
        recPath[src] = true;

        for (int v : l.get(src)) {
            if (!vis[v]) {
                if (findCycle(l, v, vis, recPath)) {
                    return true;
                }

            } else if (recPath[v]) {
                return true;
            }
        }

        recPath[src] = false;
        return false;
    }
}
