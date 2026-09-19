class Solution {

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;

        int[] dp = new int [n ];

        for (int i = 0; i < m; i++) {
           
            for (int j = 0; j < n; j++) {
                // base case 1
                if (i == 0 && j == 0){
                    dp[j]= grid[i][j];
                    continue;
            }
                // base case 2
                if (i <0 || j < 0){
                   dp[j]= (int) 1e9;
                   continue;
                }
        

                int up =(int) 1e9;
                if(i>0) up = dp[j];
                int left = (int) 1e9;
                if(j>0) left = dp[j - 1];

                dp[j] = grid[i][j] + Math.min(up, left);
            }
           
        }
       return dp[n-1];
    }
}