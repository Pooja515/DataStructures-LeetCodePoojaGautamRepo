class Solution {

    public int uniquePaths(int m, int n) {
        if (m == 0)
            return 0;

        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            int[] cur = new int[n];

            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    cur[j] = 1;
                    continue;
                }

                int left = 0, up = 0;
                if (i > 0)
                    up = dp[j];

                if (j > 0)
                    left = cur[j - 1];

                cur[j] = left + up;
            }
            dp = cur;
        }
        return dp[n - 1];
    }
}