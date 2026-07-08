class Solution {
    public int maxProfit(int k, int[] prices) {
       int n = prices.length;
       int[][] dp = new int[2][k+1]; 
       for(int ind = n-1 ;ind >= 0 ;ind--){
        for(int trans = 1 ;trans <= k;trans++){
            dp[0][trans] = Math.max(prices[ind] + dp[1][trans-1] , 0+ dp[0][trans]);
            dp[1][trans] = Math.max(-prices[ind] + dp[0][trans] , 0+dp[1][trans]);
        }
       }
       return dp[1][k];
    }
}