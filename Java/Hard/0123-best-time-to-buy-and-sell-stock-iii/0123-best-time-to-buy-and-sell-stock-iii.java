class Solution {
   
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
       
  
       for(int i=n-1;i>=0;i--){
        for(int k=1;k<3;k++){
            int selltoday = prices[i] + dp[i+1][1][k-1];
            int skip = 0 + dp[i+1][0][k];
            dp[i][0][k]=Math.max(selltoday,skip);

            int buytoday =  -prices[i] + dp[i+1][0][k];
            int skiptoday = 0 + dp[i+1][1][k];
            dp[i][1][k]=Math.max(buytoday,skiptoday);
        }
       }
       return dp[0][1][2];

    }
}