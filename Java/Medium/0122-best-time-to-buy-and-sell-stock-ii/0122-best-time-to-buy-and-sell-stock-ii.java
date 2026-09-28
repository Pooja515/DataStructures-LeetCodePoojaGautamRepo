class Solution {
   
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[2];
        for(int i=n-1;i>=0;i--){
            int[] cur = new int[2];
            int selltoday = prices[i] + dp[1];
            int skiptoday = 0 + dp[0];
            cur[0]= Math.max(selltoday , skiptoday);

            int buytoday = -prices[i] + dp[0];
            int skip = 0 + dp[1];
            cur[1]= Math.max(buytoday , skip);

            dp=cur;
    
        }
   return dp[1];
    }
}