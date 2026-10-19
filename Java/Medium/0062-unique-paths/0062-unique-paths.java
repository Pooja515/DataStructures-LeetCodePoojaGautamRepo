class Solution {
    public int uniquePaths(int m, int n) {

        int[][] memo = new int[m][n];
        for(int[] rows:memo){
            Arrays.fill(rows,-1);
        }
        
        return f(m-1,n-1,memo);
    }

    int f(int i,int j,int[][] memo){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;

        if(memo[i][j] != -1) return memo[i][j];

        int left = f(i,j-1,memo);
        int right = f(i-1,j,memo);

        return memo[i][j] =  left + right;
    }
}