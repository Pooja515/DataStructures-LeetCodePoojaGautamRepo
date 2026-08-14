class Solution {

    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n+1][amount + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

         for(int target = 0 ;target <= amount ;target++){
            if(target % coins[0] ==0){
                  dp[0][target] = 1;
            }
            else
                    dp[0][target] = 0;
        }
        

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= amount; t++) {

                int nottake = dp[i - 1][t];

                int take = 0;

                if (coins[i] <= t) {
                    take = dp[i][t - coins[i]];
                }

                dp[i][t] = take + nottake;
            }
        }

        return dp[n - 1][amount];

    }
}