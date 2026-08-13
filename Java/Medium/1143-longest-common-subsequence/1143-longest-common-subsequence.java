class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int ind1 = 0; ind1 <= m ; ind1++) {
            for (int ind2 = 0; ind2 <=n; ind2++) {
                if (ind1 == 0 || ind2 == 0)
                    dp[ind1][ind2] = 0;

                else {
                    if (text1.charAt(ind1-1) == text2.charAt(ind2-1))
                          dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                    else 
                         dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }
        return dp[m][n];
    }

}