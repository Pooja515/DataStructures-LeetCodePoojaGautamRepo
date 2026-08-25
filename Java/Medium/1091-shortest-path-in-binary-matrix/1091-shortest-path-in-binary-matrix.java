class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int n=grid.length;
        Queue<int[]> q=new LinkedList<>();
        
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        boolean[][] visited = new boolean[n][n];

        q.offer(new int[] {0,0,1});
        visited[0][0] = true;

      int[][] directions ={{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,1},{1,-1}};
      while(!q.isEmpty()){
        int[] curr  = q.poll();
        int r = curr[0] , c = curr[1], dist = curr[2];
          if(r == n-1 && c ==n-1) return dist;
        for(int[] d:directions){
            
              int newr = r +d[0] , newc= c+d[1];
              if(newr >=0 && newr<n && newc>=0 && newc < n && grid[newr][newc] == 0 && !visited[newr][newc] ){
                visited[newr][newc] = true;
                q.offer(new int[] {newr , newc ,dist+1});
              }
        }
      
      }
      return -1;
       
    }
}