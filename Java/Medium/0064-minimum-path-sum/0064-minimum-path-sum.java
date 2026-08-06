class Solution {
    int[][] memo;
    public int minPathSum(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        if(m==0 || n==0) return 0;
        memo = new int[m][n];
        for(int[] rows : memo){
            Arrays.fill(rows,-1);
        }

        return f(m-1,n-1,grid) == (int) 1e9 ? -1:f(m-1,n-1,grid);
    }
    int f(int i, int j , int[][] grid){
        //base case
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return (int) 1e9;
        int left= (int) 1e9;
        int up = (int) 1e9;

        if(memo[i][j] != -1) return memo[i][j];
        if(i>0) {
            up = f(i-1,j,grid);
        }
        if(j>0){
            left = f(i,j-1,grid);
        }

       memo[i][j] = grid[i][j] + Math.min(up , left);
       return memo[i][j];
    }
}