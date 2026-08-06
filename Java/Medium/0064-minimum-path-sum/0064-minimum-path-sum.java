class Solution {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m == 0 || n == 0)
            return 0;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    if (i < 0 || j < 0)
                        dp[i][j] = (int) 1e9;
                    else {
                        int left = (int) 1e9;
                        int up = (int) 1e9;
                        if (i > 0) {
                            up = dp[i - 1][j];
                        }
                        if (j > 0) {
                            left = dp[i][j - 1];
                        }

                        dp[i][j] = grid[i][j] + Math.min(up, left);
                    }

                }
            }
        }

        return dp[m-1][n-1];
    }
}