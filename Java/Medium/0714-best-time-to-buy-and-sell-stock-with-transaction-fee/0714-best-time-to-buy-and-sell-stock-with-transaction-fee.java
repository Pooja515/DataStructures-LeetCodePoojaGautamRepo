class Solution {
   
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
         int[] dp = new int[2];
         dp[0] =0;
         dp[1] =0;
       
         for(int i=n-1;i>=0;i--){
             int[] cur = new int[2];
            cur[0]= Math.max(prices[i] + dp[1] - fee ,dp[0]);
            cur[1]= Math.max(-prices[i] + dp[0] ,dp[1]);
            dp=cur;
         }
        return dp[1];
    }
}