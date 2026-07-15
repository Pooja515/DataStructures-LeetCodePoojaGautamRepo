class Solution {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[] dp = new int[n];
        for(int i=0 ;i<m ;i++){
             int[] cur = new int[n];
            for(int j =0;j<n ;j++){
                 if (i == 0 && j == 0){
                     cur[j] = grid[i][j];
                     continue;
                 }

        int up = (int) 1e9;
        int left = (int) 1e9;
   
        if (i > 0) up = dp[j];
        if (j > 0) left = cur[j - 1];

        cur[j] = grid[i][j] + Math.min(up, left);
            }
            dp = cur;
        }
      return dp[n-1];
    }
}