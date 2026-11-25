class Solution {
    int maxA = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        boolean[][] vis = new boolean[n][m];
        for (boolean[] row : vis) {
            Arrays.fill(row, false);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    int area= dfs(i, j, grid, vis, n, m, ans);
                    maxA= Math.max(maxA, area);
                }
            }
        }
        return maxA;
    }
    public int dfs(int i, int j, int[][] grid, boolean[][] vis, int n, int m, int ans) {
        if (i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] != 1) {
            return 0;
        }

        vis[i][j] = true;
        int d= dfs(i + 1, j, grid, vis, n, m, ans);
        int r= dfs(i, j + 1, grid, vis, n, m, ans);
        int u= dfs(i - 1, j, grid, vis, n, m, ans);
        int l=dfs(i, j - 1, grid, vis, n, m, ans);

        return 1+d+r+u+l;
    }
}
