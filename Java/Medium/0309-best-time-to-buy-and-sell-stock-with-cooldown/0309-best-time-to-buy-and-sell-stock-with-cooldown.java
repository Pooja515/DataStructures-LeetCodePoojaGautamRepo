class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
       int[][] dp =new int[n+2][2]; 
       for(int i=n-1;i>=0;i--){
        int selltoday = prices[i] + dp[i+2][1];
        int skipsell = 0 + dp[i+1][0];
        dp[i][0] = Math.max(selltoday,skipsell);

        int buytoday = -prices[i] + dp[i+1][0];
        int skipbuy = 0 + dp[i+1][1];
        dp[i][1]=Math.max(buytoday,skipbuy);
       }

       return dp[0][1];
    }
}