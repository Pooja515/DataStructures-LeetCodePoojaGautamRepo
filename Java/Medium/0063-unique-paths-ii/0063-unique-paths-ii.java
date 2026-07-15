class Solution {
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;

        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        
        memo = new int[m][n];
        for(int[] r : memo){
            Arrays.fill(r , -1);
        }

        return f(m - 1, n - 1, obstacleGrid);

    }

    int f(int i, int j, int[][] obstacleGrid) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0)
            return 0;
        if (obstacleGrid[i][j] == 1)
            return 0;
        
        if(memo[i][j] != -1) return memo[i][j];
        int up = f(i - 1, j, obstacleGrid);
        int left = f(i, j - 1, obstacleGrid);

        return memo[i][j] = up + left;
    }
}