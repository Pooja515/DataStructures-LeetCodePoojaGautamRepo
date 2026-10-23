class Solution {
   
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int [amount+1];

        for(int i=0;i<=amount;i++){
          if (i % coins[0] ==0) {
                dp[i] = i / coins[0];
            } else
                 dp[i] = (int) 1e9;
        }
       
        for(int i=1;i<n;i++){
             int[] cur = new int [amount+1];
            for(int t=0;t<=amount;t++){
                int take = (int) 1e9;
                if (coins[i] <= t) {
                   take = 1 + cur[t - coins[i]];
                }
                int nottake = 0 + dp[t];

                cur[t] = Math.min(take, nottake);
            }
            dp=cur;
        }

        return dp[amount] >= (int) 1e9 ? -1:dp[amount];
    }
}