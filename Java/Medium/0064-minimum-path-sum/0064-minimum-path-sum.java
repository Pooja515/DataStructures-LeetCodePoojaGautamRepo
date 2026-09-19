class Solution {

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // base case 1
                if (i == 0 && j == 0){
                    dp[i][j]= grid[i][j];
                    continue;
            }
                // base case 2
                if (i <0 || j < 0){
                   dp[i][j]= (int) 1e9;
                   continue;
                }
        

                int up =(int) 1e9;
                if(i>0) up = dp[i - 1][j];
                int left = (int) 1e9;
                if(j>0) left = dp[i][j - 1];

                dp[i][j] = grid[i][j] + Math.min(up, left);
            }
        }
       return dp[m-1][n-1];
    }
}