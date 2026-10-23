class Solution {
   
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int i=0;i<=amount;i++){
          if (i % coins[0] ==0) {
                dp[0][i] = i / coins[0];
            } else
                 dp[0][i] = (int) 1e9;
        }
       
        for(int i=1;i<n;i++){
            for(int t=0;t<=amount;t++){
                int take = (int) 1e9;
                if (coins[i] <= t) {
                   take = 1 + dp[i][t - coins[i]];
                }
                int nottake = 0 + dp[i - 1][t];

                dp[i][t] = Math.min(take, nottake);
            }
        }

        return dp[n-1][amount] >= (int) 1e9 ? -1:dp[n-1][amount];
    }
}