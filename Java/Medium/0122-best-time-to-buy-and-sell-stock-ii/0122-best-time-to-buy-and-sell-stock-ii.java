class Solution {
  
    public int maxProfit(int[] prices) {
       int n = prices.length;
        int[]dp = new int[2];
        int[]cur = new int[2];
        cur[0] =0;
        cur[1] =0;
     
        for(int ind = n-1 ;ind>=0 ;ind--){
             cur[0]= Math.max(prices[ind] + dp[1], 0 + dp[0]);
                   
            cur[1]= Math.max(-prices[ind] + dp[0] ,0 + dp[1]);
            dp = cur;
        }

    return dp[1];
    }
}