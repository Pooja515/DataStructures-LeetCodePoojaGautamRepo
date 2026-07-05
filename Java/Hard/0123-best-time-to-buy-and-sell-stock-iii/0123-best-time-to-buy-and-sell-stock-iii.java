class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
  
        int[][][] dp = new int[n + 1][2][3]; 

for (int i = n - 1; i >= 0; i--) {
    for (int buy = 0; buy < 2; buy++) {
        // cap needs to go down to 1 because cap-1 is used below
        for (int cap = 2; cap >=1 ; cap--) { 
            if (buy == 1) {
                int take = -prices[i] + dp[i + 1][0][cap];
                int nottake = 0 + dp[i + 1][1][cap];
                dp[i][buy][cap] = Math.max(take, nottake);
            } else {
                int take = prices[i] + dp[i + 1][1][cap - 1]; // Fixed buy state to 1 after selling
                int nottake = 0 + dp[i + 1][0][cap];
                dp[i][buy][cap] = Math.max(take, nottake);
            }
        }
    }
}

// The result will be stored here (starting at day 0, looking to buy, with 2 transactions left)
return dp[0][1][2];
    }
}