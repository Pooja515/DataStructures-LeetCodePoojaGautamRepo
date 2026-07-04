class Solution {
    
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n+1][2];

        dp[n][0] =0;
        dp[n][1] =0;
       
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j < 2;j++){
                int  profit =0;
                // buy
                if(j==1){
                 //take
                int take = -prices[i] + dp[i+1][0];
                //notTake
                int notTake = 0 + dp[i + 1][1] ;
                profit = Math.max(take , notTake);
           
            }
        //sell
        else {
                //take
                int take = prices[i] +dp[i + 1][1];
                //nottake
                int notTake = 0 + dp[i + 1][0];

                profit = Math.max(take , notTake);
             
            }

          dp[i][j] = profit;

            }
        }

      return dp[0][1] ;
    }
}