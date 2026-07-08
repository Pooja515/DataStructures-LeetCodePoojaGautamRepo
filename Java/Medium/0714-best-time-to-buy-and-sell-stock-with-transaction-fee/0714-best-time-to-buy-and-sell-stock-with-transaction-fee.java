class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int ind = n-1 ; ind >= 0 ;ind--){
            //sell
            dp[ind][0] = Math.max(prices[ind] + dp[ind+1][1] - fee , 0 + dp[ind+1][0]);
            //buy
            dp[ind][1] = Math.max(-prices[ind] + dp[ind+1][0] , 0 + dp[ind+1][1]);
        }
        return dp[0][1];
    }
}