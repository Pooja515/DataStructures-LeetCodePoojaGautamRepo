class Solution {
    public int maxProfit(int k, int[] prices) {
       int n = prices.length;
       int[][] dp = new int[2][k+1]; 
       for(int i =n-1 ;i>= 0 ;i--){
        int[][] cur = new int[2][k+1]; 
        for(int j= 1 ;j<=k;j++){
            cur[0][j] = Math.max(prices[i] + dp[1][j-1] , 0+ dp[0][j]);
            cur[1][j] = Math.max(-prices[i] + dp[0][j] , 0+dp[1][j]);
        }
        dp = cur;
       }
       return dp[1][k];
    }
}