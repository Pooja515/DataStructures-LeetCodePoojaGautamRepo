class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] dp = new int [2];

        for (int ind = n - 1; ind >= 0; ind--) {
             int[] cur = new int [2];
            // can sell
            cur[0] = Math.max(prices[ind] + dp[1], dp[0]);
            // can buy
            cur[1] = Math.max(-prices[ind] + dp[0], dp[1]);
            
            dp = cur;
        }
        return dp[1];
    }
}