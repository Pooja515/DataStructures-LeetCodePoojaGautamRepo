class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid[0].length == 0) return 0;
        int m = grid.length , n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
         int maxArea = 0;
        for(int r = 0 ;r<m;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c] == 1 && !visited[r][c] ){
                    maxArea = Math.max(maxArea , bfs(r,c,grid,visited));
                }
            }
        }
        return maxArea;
    }
    int bfs(int r , int c , int[][] grid , boolean[][] visited){
        int m = grid.length , n = grid[0].length;
        int area = 1;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r,c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[] d : dirs){
                int newr =cur[0] + d[0] ,newc = cur[1] + d[1];
        
                if(newr >= 0 && newr < m && newc >= 0 && newc < n && grid[newr][newc] == 1 && !visited[newr][newc] ){
                 visited[newr][newc] = true;
                 q.offer(new int[] {newr , newc});
                 area++;
                
                }
            }
           
        }
        return area;
    }
}