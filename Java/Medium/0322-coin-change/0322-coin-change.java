class Solution {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
//i==0,check divisibility for every target t
    
    for(int t=0 ;t<=amount;t++){
        if (t % coins[0] == 0) {
            dp[0][t] = t/coins[0];
        } else
            dp[0][t] = (int) 1e9;


    }
        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= amount; t++) {
                int nottake = 0 + dp[i - 1][t];
                int take = (int) 1e9;
                if (coins[i] <= t) {
                    take = 1 + dp[i][t - coins[i]];
                }

                dp[i][t] = Math.min(take, nottake);
            }
        }
        int res = dp[n - 1][amount];
        return res >= (int) 1e9 ? -1 : res;

    }

}