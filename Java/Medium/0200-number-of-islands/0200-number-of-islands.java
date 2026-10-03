class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {
        int m = grid.length , n= grid[0].length;
        int island =0;

        boolean[][] visited = new boolean[m][n];

        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(!visited[r][c] && grid[r][c] == '1'){
                    dfs(r,c,grid,visited,m,n);
                    island++;
                }
            }
        }
        return island;
    }

    void dfs(int r,int c,char[][] grid,boolean[][] visited , int m,int n ){
        visited[r][c] =true;
        for(int[] d:dir){
            int newr = r+d[0] , newc = c+d[1];
            if(newr >=0 && newr<m && newc>=0 && newc<n && !visited[newr][newc] && grid[newr][newc] == '1'){
                dfs(newr,newc,grid,visited,m,n);
            }
        }
    }
}