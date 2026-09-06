class Solution {

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n)
            return 0;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(j==0) {
                    dp[i][j] =1;
                    continue;
                }
                if(i==0){
                    dp[i][j] =0;
                    continue;
                }
                int take = 0, nottake = 0;
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    take = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    nottake = dp[i - 1][j];
                }

                dp[i][j] = take + nottake;
            }

        }

        return dp[m][n];

    }
}