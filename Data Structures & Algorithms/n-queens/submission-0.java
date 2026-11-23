class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] matrix = new char[n][n];
        int[][] attacked = new int[n][n];

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                matrix[a][b] = '.';
            }
        }

        for (int j = 0; j < n; j++) {
            List<Character> curr = new ArrayList<>();

            helper(0, j, n, ans, matrix, attacked);
        }

        return ans;
    }

    private void markAttacked(int i, int j, int n, int[][] attacked, int delta) {
        for (int a = i + 1; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (b == j || Math.abs(a - i) == Math.abs(b - j)) {
                    attacked[a][b] += delta;
                }
            }
        }
    }


        public void helper(
            int i, int j, int n, List<List<String>> ans, char[][] matrix, int[][] attacked) {


            matrix[i][j] = 'Q';
            if (i == n - 1) {
                List<String> curr = new ArrayList<>();
                for (int r = 0; r < n; r++) {
                    curr.add(new String(matrix[r]));
                }
                ans.add(curr);
                matrix[i][j] = '.';
                return;
            }

            markAttacked(i, j, n, attacked, 1);

            for (int b = 0; b < n; b++) {
                if (attacked[i + 1][b] == 0) {
                    helper(i + 1, b, n, ans, matrix, attacked);
                }
            }

            markAttacked(i, j, n, attacked, -1);
            matrix[i][j] = '.';
        }
    }

