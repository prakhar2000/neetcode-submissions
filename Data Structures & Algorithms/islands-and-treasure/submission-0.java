class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        for (boolean[] v : vis) {
            Arrays.fill(v, false);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new Pair<>(new Pair<>(i, j), 0));
                    vis[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair<Pair<Integer, Integer>, Integer> temp = q.poll();
            int i = temp.getKey().getKey();
            int j = temp.getKey().getValue();
            int dist = temp.getValue();

            if (i - 1 >= 0 && !vis[i - 1][j] && grid[i - 1][j] == Integer.MAX_VALUE) {
                q.offer(new Pair<>(new Pair<>(i - 1, j), dist + 1));
                grid[i - 1][j] = dist + 1;
                vis[i - 1][j] = true;
            }
            if (j - 1 >= 0 && !vis[i][j-1] && grid[i][j-1] == Integer.MAX_VALUE) {
                q.offer(new Pair<>(new Pair<>(i , j-1), dist + 1));
                grid[i][j-1] = dist + 1;
                vis[i][j-1] = true;
            }
            if (i +1 <n && !vis[i + 1][j] && grid[i +1][j] == Integer.MAX_VALUE) {
                q.offer(new Pair<>(new Pair<>(i + 1, j), dist + 1));
                grid[i + 1][j] = dist + 1;
                vis[i + 1][j] = true;
            }
            if (j+1<m  && !vis[i ][j+1] && grid[i ][j+1] == Integer.MAX_VALUE) {
                q.offer(new Pair<>(new Pair<>(i , j+1), dist + 1));
                grid[i][j+1] = dist + 1;
                vis[i ][j+1] = true;
            }
        }

        return ;
    }
}
