class Solution {
   
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][3];
       
  
       for(int i=n-1;i>=0;i--){
           int[][] cur = new int[2][3];
        for(int k=1;k<3;k++){
            int selltoday = prices[i] + dp[1][k-1];
            int skip = 0 + dp[0][k];
            cur[0][k]=Math.max(selltoday,skip);

            int buytoday =  -prices[i] + dp[0][k];
            int skiptoday = 0 + dp[1][k];
            cur[1][k]=Math.max(buytoday,skiptoday);

        }
          dp=cur;
       }
       return dp[1][2];

    }
}