class Solution {

    public int uniquePaths(int m, int n) {
        if (m == 0)
            return 0;

        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = 1;
                    continue;
                }

                int left = 0, up = 0;
                if (i > 0)
                    up = dp[j];
                if (j > 0)
                    left = dp[j - 1];
                dp[j] = left + up;
            }
       
        }
        return dp[n - 1];
    }
}