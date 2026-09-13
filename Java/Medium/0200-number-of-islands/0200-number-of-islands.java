class Solution {
    int[][] dirc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int island = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid, visited, m, n);
                    island++;
                }
            }
        }
        return island;

    }

    void dfs(int r, int c, char[][] grid, boolean[][] visited, int m, int n) {
        visited[r][c] = true;
        for (int[] dir : dirc) {
            int newr = r + dir[0], newc = c + dir[1];
            if (newr >= 0 && newr < m && newc >= 0 && newc < n && grid[newr][newc] == '1' && !visited[newr][newc]) {
                dfs(newr, newc, grid, visited, m, n);
            }
        }
    }
}