class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length, island = 0;
        boolean[][] visited = new boolean[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    dfs(r, c, grid, visited);
                    island++;

                }
            }
        }
        return island;
    }

    int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    void dfs(int r, int c, char[][] grid, boolean[][] visited) {
        visited[r][c] = true;
        for (int[] d : dir) { // explore neighbors
            int newr = r + d[0], newc = c + d[1];
            if (newr >= 0 && newr < grid.length && newc >= 0 && newc < grid[0].length && grid[newr][newc] == '1'
                    && !visited[newr][newc]) {
                dfs(newr, newc, grid, visited);
            }
        }

    }
}