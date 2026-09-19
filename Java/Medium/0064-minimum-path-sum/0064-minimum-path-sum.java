class Solution {

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;

        int[] dp = new int [n ];

        for (int i = 0; i < m; i++) {
             int[] cur = new int [n];
            for (int j = 0; j < n; j++) {
                // base case 1
                if (i == 0 && j == 0){
                    cur[j]= grid[i][j];
                    continue;
            }
                // base case 2
                if (i <0 || j < 0){
                   cur[j]= (int) 1e9;
                   continue;
                }
        

                int up =(int) 1e9;
                if(i>0) up = dp[j];
                int left = (int) 1e9;
                if(j>0) left = cur[j - 1];

                cur[j] = grid[i][j] + Math.min(up, left);
            }
            dp=cur;
        }
       return dp[n-1];
    }
}