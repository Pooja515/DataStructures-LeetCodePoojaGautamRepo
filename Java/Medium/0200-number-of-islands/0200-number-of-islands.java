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
                    visited[i][j] = true;
                    dfs(i,j,grid,visited,m,n);
                    island++;
                }
                else
                      continue;
               
            }
        }
        return island;
    }
    void dfs(int i , int j ,char[][] grid , boolean[][] visited , int m , int n){
     
        for(int[] d : dir){
            int newr = i+d[0] , newc = j+d[1];
            if(newr >= 0 && newr < m && newc >=0 && newc < n && grid[newr][newc] == '1' && !visited[newr][newc]){
                visited[newr][newc] = true;
                dfs(newr,newc,grid,visited,m,n);

            } 
        }
    }
}