class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[] dp = new int[n + 1];

        for (int i = 0; i <= m; i++) {
            int[] cur = new int[n + 1];
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    cur[j] = 0;
                } else {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        cur[j] = 1 + dp[j - 1];
                    } else {
                        cur[j] = Math.max(dp[j], cur[j - 1]);
                    }

                }

            }
            dp = cur;
        }

        return dp[n];
    }
}