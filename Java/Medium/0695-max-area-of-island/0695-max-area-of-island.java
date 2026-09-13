class Solution {
    int[][] dirc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    public int maxAreaOfIsland(int[][] grid) {
      
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int maxArea= 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                   maxArea = Math.max(dfs(i, j, grid, visited, m, n), maxArea);
                   
                }
            }
        }
        return maxArea;

    }

    int dfs(int r, int c, int[][] grid, boolean[][] visited, int m, int n) {
        visited[r][c] = true;
        int island =1;
        for (int[] dir : dirc) {
            int newr = r + dir[0], newc = c + dir[1];
            if (newr >= 0 && newr < m && newc >= 0 && newc < n && grid[newr][newc] == 1 && !visited[newr][newc]) {
                island += dfs(newr, newc, grid, visited, m, n);
            }
        } 
        return island; 
    }
}




   
    