class Solution {
   
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i=n-1;i>=0;i--){
            int selltoday = prices[i] + dp[i+1][1];
            int skiptoday = 0 + dp[i+1][0];
            dp[i][0]= Math.max(selltoday , skiptoday);

            int buytoday = -prices[i] + dp[i+1][0];
            int skip = 0 + dp[i+1][1];
            dp[i][1]= Math.max(buytoday , skip);
    
        }
   return dp[0][1];
    }
}