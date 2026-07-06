class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int ind= n-1 ; ind >= 0 ; ind--){
            for(int trans = 1;trans <= 2 ; trans++ ){
                dp[ind][0][trans] = Math.max(prices[ind] + dp[ind+1][1][trans-1] , dp[ind+1][0][trans]);
                dp[ind][1][trans] = Math.max(-prices[ind] + dp[ind+1][0][trans] , dp[ind+1][1][trans]);
            }
        }
        return dp[0][1][2];
    }
}