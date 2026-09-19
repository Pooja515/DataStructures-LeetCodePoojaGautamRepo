class Solution {
    int[][] memo;
    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;

        memo = new int[m][n];
        for(int[] rows : memo){
            Arrays.fill(rows,(int) 1e9);
        }

        return f(m - 1, n - 1, grid);

    }

    int f(int i, int j, int[][] grid) {

        // base case 1
        if (i == 0 && j == 0)
            return grid[i][j];
        // base case 2
        if (i < 0 || j < 0)
            return (int) 1e9;
        
        if(memo[i][j] != (int) 1e9) return memo[i][j];

        int up = f(i - 1, j, grid);
        int left = f(i, j - 1, grid);

        return memo[i][j] =grid[i][j] + Math.min(up, left);
    }
}