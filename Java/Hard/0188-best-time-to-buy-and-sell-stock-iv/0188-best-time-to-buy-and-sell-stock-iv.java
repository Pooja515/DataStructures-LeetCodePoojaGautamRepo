class Solution {
   
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;

        if(n==0 || k==0) return 0;
        int[][][] dp =new int[n+1][2][k+1];

        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=k;j++){
               int selltoday= prices[i] +dp[i+1][1][j-1];
               int skipsell= 0 +dp[i+1][0][j];
               dp[i][0][j]=Math.max(selltoday,skipsell);

                int buytoday= -prices[i] +dp[i+1][0][j];
                int skiptoday= 0 +dp[i+1][1][j];
                dp[i][1][j]=Math.max(buytoday,skiptoday);
            }
        }
      return dp[0][1][k];
    }
}