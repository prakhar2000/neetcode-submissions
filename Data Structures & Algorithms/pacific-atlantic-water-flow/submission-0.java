class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacVis = new boolean[n][m];
        boolean[][] atlVis = new boolean[n][m];
        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            pacQ.offer(new int[] {i, 0});
            pacVis[i][0] = true;
            atlQ.offer(new int[] {i, m - 1});
            atlVis[i][m - 1] = true;
        }
        for (int j = 0; j < m; j++) {
            pacQ.offer(new int[] {0, j});
            pacVis[0][j] = true;
            atlQ.offer(new int[] {n - 1, j});
            atlVis[n - 1][j] = true;
        }
        bfs(heights, pacQ, pacVis, n, m);
        bfs(heights, atlQ, atlVis, n, m);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacVis[i][j] && atlVis[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    public void bfs(int[][] heights, Queue<int[]> q, boolean[][] vis, int n, int m) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && !vis[nr][nc]
                        && heights[nr][nc] >= heights[r][c]) {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }



        }
    }
}
