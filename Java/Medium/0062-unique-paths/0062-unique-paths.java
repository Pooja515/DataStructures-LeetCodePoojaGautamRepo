class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        if (m == 0)
            return 0;
        memo = new int[m][n];

        for(int[] r:memo) Arrays.fill(r,-1);

        return f(m - 1, n - 1);

    }

    int f(int i, int j) {
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int left = f(i, j - 1);
        int up = f(i - 1, j);

        return memo[i][j] = left + up;

    }
}