class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[] dp = new int [n + 1];

        for (int ind1 = 0; ind1 <= m; ind1++) {
             int[] cur = new int [n + 1];
            for (int ind2 = 0; ind2 <= n; ind2++) {
                if (ind1 == 0 || ind2 == 0) {
                    cur[ind2] = 0;
                } else {
                    // match
                    if (text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1)) {
                        cur[ind2] = 1 + dp[ind2 - 1];
                    } else
                        //not match
                        cur[ind2] = Math.max(dp[ind2], cur[ind2 - 1]);
                }
            }
            dp=cur;
        }
        return dp[n];
    }
}