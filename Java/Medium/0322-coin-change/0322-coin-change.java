class Solution {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int [amount + 1];

        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) {
                dp[t] = t / coins[0];
            } else
                dp[t] = (int) 1e9;

        }

        for (int ind = 1; ind < n; ind++) {
             int[] cur = new int [amount + 1];
            for (int t = 0; t <= amount; t++) {
                //nottake
                int nottake = 0 + dp[t];
                int take = (int) 1e9;
                if (coins[ind] <= t) {
                    take = 1 + cur[t - coins[ind]];
                }

                cur[t] = Math.min(take, nottake);
            }
            dp=cur;
        }
        return dp[amount] >= (int) 1e9 ?-1:dp[amount];
    }
}