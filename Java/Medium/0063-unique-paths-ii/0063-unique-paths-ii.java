class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;

        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
               int[] cur = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                      cur[j] =1;
                      continue;
                }
                
                if (obstacleGrid[i][j] == 1){
                    cur[j] =  0;
                    continue;
                }
                

                int up = 0 , left = 0;
                if(i>0) up =   dp[j];
                if(j>0) left = cur[j - 1];

                cur[j] = up + left;
            }
            dp = cur;
        }
       return dp[n-1];
    }
}