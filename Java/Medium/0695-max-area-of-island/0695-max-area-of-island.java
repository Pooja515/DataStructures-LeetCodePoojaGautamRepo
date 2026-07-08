class Solution {
    int[][] dir = {{-1,0},{1,0} , {0,-1},{0,1}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length , n = grid[0].length;
        if(grid == null || m==0) return 0;
        boolean[][] visited = new boolean[m][n];
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                 if(grid[r][c] == 1 && !visited[r][c]){
                    maxArea = Math.max(maxArea , dfs(r,c,grid,visited,m,n));
                 } 
            }
        }
        return maxArea;
    }
    int dfs(int r,int c,int[][] grid , boolean[][] visited ,int m ,int n){
        int area =1;
        visited[r][c] = true;
        for(int[] d : dir){
            int newr = r + d[0] , newc = c + d[1];
            if(newr >= 0 && newr <m && newc >= 0 && newc <n && grid[newr][newc] == 1 && !visited[newr][newc]){
                area += dfs(newr , newc , grid, visited , m , n);
            }
        }
        return area;
    }
}