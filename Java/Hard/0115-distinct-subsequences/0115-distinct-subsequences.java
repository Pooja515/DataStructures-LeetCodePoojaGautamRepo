class Solution {

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (n == 0)
            return 0;
        if (m < n)
            return 0;

        int[][] dp = new int[m + 1][n + 1];

        for(int i=0;i<=m;i++){
            dp[i][0] =1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 0)
                    dp[0][0] = 1;
                if (i == 0)
                    dp[i][j] = 0;
                // take
                else if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[m][n];
    }
}