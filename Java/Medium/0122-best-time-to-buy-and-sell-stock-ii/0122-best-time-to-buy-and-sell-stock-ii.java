class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int[] dp = new int[2];
  
        for(int i = n-1;i>=0;i--){
          dp[0] = Math.max(prices[i] + dp[1], 0 + dp[0]);
         
          dp[1] = Math.max(-prices[i] + dp[0], 0 + dp[1]);
        }
        return dp[1];
    }
}
