class Solution {
    int[][] memo;
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        memo = new int[m][n];
        for(int[] r : memo) {
            Arrays.fill(r , -1);
        }
        return f(m - 1, n - 1, grid);
    }

    int f(int i, int j, int[][] grid) {
        if (i == 0 && j == 0)
            return grid[i][j];
        if (i < 0 || j < 0)
            return (int) 1e9;

        int up = (int) 1e9;
        int left = (int) 1e9;
        if(memo[i][j] != -1) return memo[i][j];
        if (i > 0)
            up = f(i - 1, j, grid);
        if (j > 0)
            left = f(i, j - 1, grid);

        return memo[i][j] =  grid[i][j] + Math.min(up, left);
    }
}