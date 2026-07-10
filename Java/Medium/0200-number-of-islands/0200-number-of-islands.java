class Solution {
    int[][] dir = {{-1,0}, {1,0},{0,-1} ,{0,1}};
    public int numIslands(char[][] grid) {
        int m = grid.length , n= grid[0].length;
        boolean[][] visited = new boolean [m][n];
        int island = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' && !visited[i][j])
                {
                    bfs(i,j,grid,visited,m,n);
                    island++;
                }
                else
                      continue;
               
            }
        }
        return island;
    }
    private void bfs(int r, int c, char[][] grid, boolean[][] visited, int m, int n) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true; // Mark as visited as soon as it enters the queue
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            
            // Check all 4 neighboring directions
            for (int[] d : dir) {
                int newRow = currRow + d[0];
                int newCol = currCol + d[1];
                
                // Ensure boundaries, check if it's land, and make sure it's not visited
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n 
                    && grid[newRow][newCol] == '1' && !visited[newRow][newCol]) {
                    
                    visited[newRow][newCol] = true; // Mark immediately to avoid duplicate queue entries
                    queue.offer(new int[]{newRow, newCol});
                    }
            } 
        }
    }
}