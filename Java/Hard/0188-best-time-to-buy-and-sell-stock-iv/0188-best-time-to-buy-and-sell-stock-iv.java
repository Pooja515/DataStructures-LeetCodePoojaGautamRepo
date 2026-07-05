class Solution {

    public int maxProfit(int k, int[] prices) {

        int n = prices.length;

        int[][][] dp = new int[n + 1][2][k+1];

        for (int day = n - 1; day >= 0; day--) {

            for (int transactionsLeft = 1; transactionsLeft <= k; transactionsLeft++) {

                // Not holding stock
                dp[day][0][transactionsLeft] = Math.max(
                        -prices[day] + dp[day + 1][1][transactionsLeft],
                        dp[day + 1][0][transactionsLeft]
                );

                // Holding stock
                dp[day][1][transactionsLeft] = Math.max(
                        prices[day] + dp[day + 1][0][transactionsLeft - 1],
                        dp[day + 1][1][transactionsLeft]
                );
            }
        }

        return dp[0][0][k];
    }
}