class Solution {
  
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];
        
        for(int target = 0 ;target <=amount ;target++){
            if(target % coins[0] == 0){
                 dp[0][target] = target/coins[0];
            }
            else
                 dp[0][target] = (int) 1e9;
           
        }

        for(int ind = 1;ind < n ;ind++){
            for(int target = 0 ; target <= amount ;target++){
            int notpick = 0 + dp[ind - 1][target];
            int pick = (int) 1e9;
            if (coins[ind] <= target) {
                pick = 1 + dp[ind][target - coins[ind]];
            }

            dp[ind][target] =  Math.min(pick, notpick);
            }
        }
        return dp[n-1][amount] >= (int) 1e9 ?-1 : dp[n-1][amount];
    }
}