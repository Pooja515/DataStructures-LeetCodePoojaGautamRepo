class Solution {
    int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // lets do boundary check
        for (int r = 0; r < m; r++) {
            if (grid[r][0] == 1) {
                dfs(r, 0, grid, m, n);
            }
            if (grid[r][n - 1] == 1) {
                dfs(r, n - 1, grid, m, n);
            }

        }

        for (int c = 0; c < n; c++) {
            if (grid[0][c] == 1) {
                dfs(0, c, grid, m, n);
            }

            if (grid[m - 1][c] == 1) {
                dfs(m - 1, c, grid, m, n);
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    cnt++;
            }
        }

        return cnt;
    }

    void dfs(int r, int c, int[][] grid, int m, int n) {
        grid[r][c] = -1;
        for (int[] d : dir) {
            int newr = r + d[0], newc = c + d[1];
            if (newr >= 0 && newr < m && newc >= 0 && newc < n && grid[newr][newc] == 1) {
                dfs(newr, newc, grid, m, n);
            }
        }
    }
}