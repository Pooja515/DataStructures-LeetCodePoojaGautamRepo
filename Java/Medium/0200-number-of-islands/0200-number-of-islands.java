class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        int island = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                    island++;
                }
            }
        }
        return island;
    }

    int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    void dfs(int r,int c,char[][] grid,boolean[][] visited){
        visited[r][c]=true;

        for(int[] d:dir){
            int newr = r+d[0] , newc=c+d[1];
            if(newr >= 0 && newr < grid.length && newc >= 0 && newc < grid[0].length && grid[newr][newc] == '1' && !visited[newr][newc]){
                dfs(newr,newc,grid,visited);
              
            }
        }

    }
}